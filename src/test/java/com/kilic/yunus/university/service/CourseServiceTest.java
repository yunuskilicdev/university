package com.kilic.yunus.university.service;

import com.kilic.yunus.university.data.CourseDto;
import com.kilic.yunus.university.data.DepartmentDto;
import com.kilic.yunus.university.data.ProfessorDto;
import com.kilic.yunus.university.data.model.Course;
import com.kilic.yunus.university.data.model.Department;
import com.kilic.yunus.university.data.model.Professor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class CourseServiceTest {

    private final Integer preInitCourseSize = 10;

    @Autowired
    CourseService courseService;

    @Autowired
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void listAll() {
        List<Course> courses = courseService.listAll();
        assertEquals(preInitCourseSize, courses.size());
    }

    @Test
    void getById() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);

        CourseDto courseDto = new CourseDto();
        courseDto.setName("Test");
        courseDto.setCredits(1);
        courseDto.setDepartmentId(department.getId());
        Course course = courseService.create(courseDto);

        Course response = courseService.getById(course.getId());
        assertNotNull(response);
        assertNotNull(response.getId());
    }

    @Test
    void whenIdNotExists_ThenGetByIdThrowsException() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            courseService.getById(-1);
        });
        assertEquals("Course not found", exception.getReason());
    }

    @Test
    void deleteById() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);

        CourseDto courseDto = new CourseDto();
        courseDto.setName("Test");
        courseDto.setCredits(1);
        courseDto.setDepartmentId(department.getId());
        Course course = courseService.create(courseDto);

        assertAll(() -> courseService.deleteById(course.getId()));
    }

    @Test
    void whenIdNotExists_ThenDeleteByIdThrowsException() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            courseService.deleteById(-1);
        });
        assertEquals("Course not found", exception.getReason());
    }

    @Test
    void create() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("Test");
        Department department = departmentService.create(departmentDto);
        CourseDto courseDto = new CourseDto();
        courseDto.setCredits(1);
        courseDto.setName("Test");
        courseDto.setDepartmentId(department.getId());
        Course course = courseService.create(courseDto);
        assertNotNull(course.getId());
    }

    @Test
    void whenDepartmentNotExist_ThenCreateThrowsException() {
        CourseDto courseDto = new CourseDto();
        courseDto.setCredits(1);
        courseDto.setName("Test");
        courseDto.setDepartmentId(-1);
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            courseService.create(courseDto);
        });
        assertEquals("Department not found", exception.getReason());
    }
}