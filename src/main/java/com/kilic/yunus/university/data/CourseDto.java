package com.kilic.yunus.university.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private String name;
    private Integer departmentId;
    private Integer credits;
}
