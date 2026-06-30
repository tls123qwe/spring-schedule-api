package com.example.schedulesmanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends LocalTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    private String contents;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(String writer, String contents, String password, Schedule schedule) {
        this.writer = writer;
        this.contents = contents;
        this.password = password;
        this.schedule = schedule;
    }

    public void updateComment(String writer, String contents){
        this.writer = writer;
        this.contents = contents;
    }
}
