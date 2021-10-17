package com.kilic.yunus.university.service;

import com.kilic.yunus.university.data.ScheduleDto;
import com.kilic.yunus.university.data.model.*;
import com.kilic.yunus.university.data.repository.CourseRepository;
import com.kilic.yunus.university.data.repository.ProfessorRepository;
import com.kilic.yunus.university.data.repository.ScheduleRepository;
import com.kilic.yunus.university.mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ScheduleService {

    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;
    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    public List<ScheduleDto> listAll() {
        List<Schedule> all = scheduleRepository.findAll();
        return all.stream().map(x->scheduleMapper.scheduleDto(x)).collect(Collectors.toList());
    }

    public void deleteById(ScheduleDto dto) {
        ScheduleId scheduleId = scheduleMapper.scheduleId(dto);
        Optional<Schedule> byId = scheduleRepository.findById(scheduleId);
        if (byId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Schedule not found");
        }
        scheduleRepository.deleteById(scheduleId);
    }

    public ScheduleDto create(ScheduleDto dto) {
        ScheduleId scheduleId = scheduleMapper.scheduleId(dto);
        Optional<Schedule> byId = scheduleRepository.findById(scheduleId);
        if (byId.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department name exists");
        }

        Optional<Course> byIdCourse = courseRepository.findById(dto.getCourseId());
        if (!byIdCourse.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course not found");
        }

        Optional<Professor> byIdProfessor = professorRepository.findById(dto.getProfessorId());
        if (!byIdProfessor.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Professor not found");
        }
        Schedule schedule = new Schedule();
        schedule.setCourse(byIdCourse.get());
        schedule.setSemester(dto.getSemester());
        schedule.setYear(dto.getYear());
        Professor professor = byIdProfessor.get();
        professor.AddSchedule(schedule);
        professorRepository.save(professor);
        return dto;
    }
}
