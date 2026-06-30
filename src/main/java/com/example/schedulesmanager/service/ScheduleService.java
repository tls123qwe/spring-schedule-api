package com.example.schedulesmanager.service;

import com.example.schedulesmanager.dto.CreatRequest;
import com.example.schedulesmanager.dto.CreatResponse;
import com.example.schedulesmanager.dto.GetRequest;
import com.example.schedulesmanager.dto.GetResponse;
import com.example.schedulesmanager.entity.Schedule;
import com.example.schedulesmanager.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreatResponse creatSchedule(CreatRequest request) {
        Schedule schedule = new Schedule(
                request.getWriter(),
                request.getTitle(),
                request.getContents(),
                request.getPassword());

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreatResponse(
                savedSchedule.getId(),
                savedSchedule.getWriter(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public GetResponse getOne(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다."));

        return new GetResponse(
                schedule.getId(),
                schedule.getWriter(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetResponse> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<GetResponse> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new GetResponse(
                    schedule.getId(),
                    schedule.getWriter(),
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public List<GetResponse> findByWriter(String writer) {
        List<Schedule> schedules = scheduleRepository.findByWriter(writer);

        List<GetResponse> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new GetResponse(
                    schedule.getId(),
                    schedule.getWriter(),
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()));
        }
        return dtos;
    }
}
