package com.example.schedulesmanager.dto;

import lombok.Getter;

@Getter
public class UpdateCommentRequest {
    private String writer;
    private String contents;
    private String Password;
}
