package com.example.schedulesmanager.dto;

import lombok.Getter;

@Getter
public class CreatRequest {
    private String writer;
    private String title;
    private String contents;
    private String password;
}
