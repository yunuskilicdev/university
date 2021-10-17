package com.kilic.yunus.university.service;

import com.kilic.yunus.university.data.DepartmentDto;
import com.kilic.yunus.university.data.ProfessorDto;
import com.kilic.yunus.university.data.SearchDto;
import com.kilic.yunus.university.data.model.Department;
import com.kilic.yunus.university.data.model.Professor;
import com.kilic.yunus.university.data.model.Schedule;
import com.kilic.yunus.university.data.repository.DepartmentRepository;
import com.kilic.yunus.university.data.repository.ProfessorRepository;
import com.kilic.yunus.university.mapper.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final DepartmentRepository departmentRepository;
    private final ProfessorRepository professorRepository;
    private final SearchMapper searchMapper;

    public SearchDto[] listAllProfessorsHaveSchedule() {
        List<Professor> all = professorRepository.findAll();
        List<SearchDto> dtos = new ArrayList<>();
        for (Professor professor : all) {
            if (CollectionUtils.isEmpty(professor.getScheduleSet())) {
                continue;
            }
            SearchDto searchDto = searchMapper.professorDto(professor);
            List<String> courseNames = professor.getScheduleSet().stream().map(x -> x.getCourse().getName()).collect(Collectors.toList());
            searchDto.setCourses(courseNames);
            dtos.add(searchDto);
        }
        return dtos.toArray(SearchDto[]::new);
    }

    public List<Professor> listAll() {
        return professorRepository.findAll();
    }

    public Professor getById(Integer id) {
        Optional<Professor> byId = professorRepository.findById(id);
        if (byId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor not found");
        }
        return byId.get();
    }

    public void deleteById(Integer id) {
        Optional<Professor> byId = professorRepository.findById(id);
        if (byId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor not found");
        }
        professorRepository.deleteById(id);
    }

    public Professor create(ProfessorDto dto) {
        Optional<Department> byId = departmentRepository.findById(dto.getDepartmentId());
        if (byId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found");
        }
        Professor professor = new Professor();
        professor.setName(dto.getName());
        professor.setDepartment(byId.get());

        Schedule schedule = new Schedule();
        return professorRepository.save(professor);
    }
}
