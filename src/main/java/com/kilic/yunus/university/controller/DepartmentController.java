package com.kilic.yunus.university.controller;

import com.kilic.yunus.university.data.DepartmentDto;
import com.kilic.yunus.university.data.model.Department;
import com.kilic.yunus.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> listAll(){
        return departmentService.listAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Integer id){
        return departmentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        departmentService.deleteById(id);
    }

    @PostMapping
    public Department create(@RequestBody DepartmentDto dto){
        return departmentService.create(dto);
    }
}
