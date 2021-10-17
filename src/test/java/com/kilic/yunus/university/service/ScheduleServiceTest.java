package com.kilic.yunus.university.service;

import com.kilic.yunus.university.data.CourseDto;
import com.kilic.yunus.university.data.DepartmentDto;
import com.kilic.yunus.university.data.ProfessorDto;
import com.kilic.yunus.university.data.ScheduleDto;
import com.kilic.yunus.university.data.model.Course;
import com.kilic.yunus.university.data.model.Department;
import com.kilic.yunus.university.data.model.Professor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ScheduleServiceTest {

    private final Integer preInitScheduleSize = 10;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    ProfessorService professorService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    CourseService courseService;

    @Test
    void listAll() {
        List<ScheduleDto> scheduleDtos = scheduleService.listAll();
        assertEquals(preInitScheduleSize, scheduleDtos.size());
    }

    @Test
    void deleteById() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setName("Test");
        professorDto.setDepartmentId(department.getId());
        Professor professor = professorService.create(professorDto);

        CourseDto courseDto = new CourseDto();
        courseDto.setName("Test");
        courseDto.setCredits(1);
        courseDto.setDepartmentId(department.getId());
        Course course = courseService.create(courseDto);

        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setSemester(1);
        scheduleDto.setYear(2011);
        scheduleDto.setCourseId(course.getId());
        scheduleDto.setProfessorId(professor.getId());

        assertAll(() ->scheduleService.create(scheduleDto));

        assertAll(() ->scheduleService.deleteById(scheduleDto));
    }

    @Test
    void create() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setName("Test");
        professorDto.setDepartmentId(department.getId());
        Professor professor = professorService.create(professorDto);

        CourseDto courseDto = new CourseDto();
        courseDto.setName("Test");
        courseDto.setCredits(1);
        courseDto.setDepartmentId(department.getId());
        Course course = courseService.create(courseDto);

        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setSemester(1);
        scheduleDto.setYear(2011);
        scheduleDto.setCourseId(course.getId());
        scheduleDto.setProfessorId(professor.getId());

        assertAll(() ->scheduleService.create(scheduleDto));
    }
}