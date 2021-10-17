package com.kilic.yunus.university.mapper;

import com.kilic.yunus.university.data.ScheduleDto;
import com.kilic.yunus.university.data.model.Schedule;
import com.kilic.yunus.university.data.model.ScheduleId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    @Mapping(source = "professor.id", target = "professorId")
    @Mapping(source = "course.id", target = "courseId")
    ScheduleDto scheduleDto(Schedule schedule);

    ScheduleId scheduleId(ScheduleDto dto);
}
