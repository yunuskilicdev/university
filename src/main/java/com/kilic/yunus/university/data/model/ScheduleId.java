package com.kilic.yunus.university.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ScheduleId implements Serializable {

    @Column(name = "professor_id")
    private Integer professorId;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "year")
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleId that = (ScheduleId) o;
        return Objects.equals(professorId, that.professorId) && Objects.equals(courseId, that.courseId) && Objects.equals(semester, that.semester) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, courseId, semester, year);
    }
}
