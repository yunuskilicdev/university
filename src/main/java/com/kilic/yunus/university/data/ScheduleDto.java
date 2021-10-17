package com.kilic.yunus.university.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
    private Integer professorId;
    private Integer courseId;
    private Integer semester;
    private Integer year;
}
