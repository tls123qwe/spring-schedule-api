package com.example.schedulesmanager.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Schedule extends LocalTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String title;
    private String contents;
    private String password;


    public Schedule(String writer, String title, String contents, String password) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.password = password;
    }

    public void updateSchedule(String writer, String title, String contents) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }
}
