package com.example.schedulesmanager.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateResponse {
    private final Long id;
    private final String writer;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UpdateResponse(Long id, String writer, String title, String contents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
