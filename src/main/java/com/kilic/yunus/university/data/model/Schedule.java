package com.kilic.yunus.university.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
public class Schedule {

    @EmbeddedId
    private ScheduleId id = new ScheduleId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("professorId")
    private Professor professor;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    private Course course;

    public Integer getSemester(){
        return id.getSemester();
    }

    public Integer getYear(){
        return id.getYear();
    }

    public void setSemester(Integer semester){
        this.id.setSemester(semester);
    }

    public void setYear(Integer year){
        this.id.setYear(year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
