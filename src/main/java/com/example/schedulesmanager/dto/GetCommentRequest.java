package com.example.schedulesmanager.dto;

import lombok.Getter;

@Getter
public class GetCommentRequest {
    private String writer;
    private String contents;
    private String password;
}
