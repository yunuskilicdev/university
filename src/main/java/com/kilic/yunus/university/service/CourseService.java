package com.kilic.yunus.university.service;

import com.kilic.yunus.university.data.CourseDto;
import com.kilic.yunus.university.data.model.Course;
import com.kilic.yunus.university.data.model.Department;
import com.kilic.yunus.university.data.model.Professor;
import com.kilic.yunus.university.data.repository.CourseRepository;
import com.kilic.yunus.university.data.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final DepartmentRepository departmentRepository;
    private final CourseRepository courseRepository;

    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    public Course getById(Integer id) {
        Optional<Course> byId = courseRepository.findById(id);
        if (byId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }
        return byId.get();
    }

    public void deleteById(Integer id) {
        Optional<Course> byId = courseRepository.findById(id);
        if (byId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }
        courseRepository.deleteById(id);
    }

    public Course create(CourseDto dto) {
        Optional<Department> byId = departmentRepository.findById(dto.getDepartmentId());
        if (byId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found");
        }
        Course course = new Course();
        course.setName(dto.getName());
        course.setDepartment(byId.get());
        course.setCredits(dto.getCredits());
        return courseRepository.save(course);
    }
}
