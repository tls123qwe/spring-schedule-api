package com.example.schedulesmanager.controller;

import com.example.schedulesmanager.dto.CreatRequest;
import com.example.schedulesmanager.dto.CreatResponse;
import com.example.schedulesmanager.dto.GetResponse;
import com.example.schedulesmanager.entity.Schedule;
import com.example.schedulesmanager.repository.ScheduleRepository;
import com.example.schedulesmanager.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class scheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;


    @PostMapping("/schedule")
    public ResponseEntity<CreatResponse> creatSchedule(@RequestBody CreatRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.creatSchedule(request));
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<GetResponse> getOneSchedule(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getOne(id));
    }
}
