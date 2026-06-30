package com.example.schedulesmanager.controller;

import com.example.schedulesmanager.dto.CreatRequest;
import com.example.schedulesmanager.dto.CreatResponse;
import com.example.schedulesmanager.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class scheduleController {

    private final ScheduleService scheduleService;


    @PostMapping("/schedule")
    public ResponseEntity<CreatResponse> creatSchedule(@RequestBody CreatRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.creatSchedule(request));
    }

}
