package com.example.schedulesmanager.service;

import com.example.schedulesmanager.dto.CreatCommentRequest;
import com.example.schedulesmanager.dto.CreatCommentResponse;
import com.example.schedulesmanager.dto.GetCommentResponse;
import com.example.schedulesmanager.entity.Comment;
import com.example.schedulesmanager.entity.Schedule;
import com.example.schedulesmanager.repository.CommentRepository;
import com.example.schedulesmanager.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreatCommentResponse creatComment(Long scheduleId, CreatCommentRequest request){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        Comment comment = new Comment(
                request.getWriter(),
                request.getContents(),
                request.getPassword(),
                schedule
        );

        Comment savedComment = commentRepository.save(comment);

        return new CreatCommentResponse(
                savedComment.getId(),
                savedComment.getWriter(),
                savedComment.getContents(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt());
    }
}
