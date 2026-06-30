package com.example.schedulesmanager.dto;

import lombok.Getter;

@Getter
public class UpdateRequest {
    private String writer;
    private String title;
    private String contents;
}
