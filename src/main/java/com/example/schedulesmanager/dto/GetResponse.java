package com.example.schedulesmanager.dto;

import lombok.Getter;
import lombok.experimental.NonFinal;

import java.time.LocalDateTime;

@Getter
public class GetResponse {
    private final Long id;
    private final String writer;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetResponse(Long id, String writer, String title, String contents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
