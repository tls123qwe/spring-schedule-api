package com.example.schedulesmanager.dto;

import lombok.Getter;

@Getter
public class CreatCommentRequest {

    private String writer;
    private String contents;
    private String password;

}
