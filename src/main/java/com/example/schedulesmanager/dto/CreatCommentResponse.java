package com.example.schedulesmanager.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreatCommentResponse {

    private final Long id;
    private final String writer;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreatCommentResponse(Long id, String writer, String contents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.writer = writer;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
