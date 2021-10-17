package com.kilic.yunus.university.data.repository;

import com.kilic.yunus.university.data.model.Schedule;
import com.kilic.yunus.university.data.model.ScheduleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, ScheduleId> {
}
