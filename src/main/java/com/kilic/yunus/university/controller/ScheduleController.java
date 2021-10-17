package com.kilic.yunus.university.controller;

import com.kilic.yunus.university.data.ScheduleDto;
import com.kilic.yunus.university.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    public List<ScheduleDto> listAll(){
        return scheduleService.listAll();
    }

    @DeleteMapping()
    public void delete(@RequestBody ScheduleDto dto){
        scheduleService.deleteById(dto);
    }

    @PostMapping
    public ScheduleDto create(@RequestBody ScheduleDto dto){
        return scheduleService.create(dto);
    }
}
