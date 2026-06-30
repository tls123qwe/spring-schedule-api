package com.example.schedulesmanager.controller;

import com.example.schedulesmanager.dto.*;
import com.example.schedulesmanager.repository.ScheduleRepository;
import com.example.schedulesmanager.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class scheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;


    @PostMapping("/schedules")
    public ResponseEntity<CreatResponse> creatSchedule(@RequestBody CreatRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.creatSchedule(request));
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<GetResponse> getOneSchedule(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getOne(id));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetResponse>> getAllSchedules(@RequestParam(required = false) String writer) {
        if (writer == null) {
            return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll());
        }
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findByWriter(writer));
    }

    @PutMapping("/schedlues/{id}")
    public ResponseEntity<UpdateResponse> updateSchedule(@PathVariable Long id, @RequestBody UpdateRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.updateSchedule(id, request));
    }

}
