package com.kilic.yunus.university.controller;

import com.kilic.yunus.university.data.DepartmentDto;
import com.kilic.yunus.university.data.ProfessorDto;
import com.kilic.yunus.university.data.model.Department;
import com.kilic.yunus.university.data.model.Professor;
import com.kilic.yunus.university.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public List<Professor> listAll(){
        return professorService.listAll();
    }

    @GetMapping("/{id}")
    public Professor getById(@PathVariable Integer id){
        return professorService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        professorService.deleteById(id);
    }

    @PostMapping
    public Professor create(@RequestBody ProfessorDto dto){
        return professorService.create(dto);
    }
}
