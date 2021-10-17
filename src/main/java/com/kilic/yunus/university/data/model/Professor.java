package com.kilic.yunus.university.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Professor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    @ManyToOne
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private Set<Schedule> scheduleSet = new HashSet<>();

    public void AddSchedule(Schedule schedule) {
        if (scheduleSet == null) {
            scheduleSet = new HashSet<>();
        }
        schedule.setProfessor(this);
        this.scheduleSet.add(schedule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
