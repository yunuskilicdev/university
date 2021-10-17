package com.kilic.yunus.university.controller;

import com.kilic.yunus.university.data.CourseDto;
import com.kilic.yunus.university.data.ProfessorDto;
import com.kilic.yunus.university.data.model.Course;
import com.kilic.yunus.university.data.model.Professor;
import com.kilic.yunus.university.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> listAll(){
        return courseService.listAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Integer id){
        return courseService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        courseService.deleteById(id);
    }

    @PostMapping
    public Course create(@RequestBody CourseDto dto){
        return courseService.create(dto);
    }
}
