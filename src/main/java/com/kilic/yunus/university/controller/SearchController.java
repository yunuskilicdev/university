package com.kilic.yunus.university.controller;

import com.kilic.yunus.university.data.SearchDto;
import com.kilic.yunus.university.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("search")
public class SearchController {
    private final ProfessorService professorService;

    @GetMapping
    public SearchDto[] search() {
        return professorService.listAllProfessorsHaveSchedule();
    }
}
