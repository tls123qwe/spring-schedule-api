package com.example.schedulesmanager.repository;

import com.example.schedulesmanager.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByWriter(String writer);
}

