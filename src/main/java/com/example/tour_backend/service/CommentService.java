package com.example.tour_backend.service;

import com.example.tour_backend.domain.comment.Comment;
import com.example.tour_backend.domain.comment.CommentRepository;
import com.example.tour_backend.domain.thread.ThreadRepository;
import com.example.tour_backend.dto.comment.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.tour_backend.domain.thread.Thread;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ThreadRepository threadRepository;

    @Transactional
    public CommentDto addComment(CommentDto dto) {
        Thread thread = threadRepository.findById(dto.getThreadid())
                .orElseThrow(() -> new RuntimeException("게시물이 존재하지 않습니다."));

        Comment comment = Comment.builder()
                .thread(thread)
                .content(dto.getContent())
                .author(dto.getAuthor())
                .build();

        commentRepository.save(comment);

        dto.setCommentid(comment.getCommentid());
        dto.setCreateDate(comment.getCreateDate());
        dto.setModifiedDate(comment.getModifiedDate());

        return dto;
    }
}
