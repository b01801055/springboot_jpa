package com.ron.springboot_jpa.service;

import com.ron.springboot_jpa.domain.Comment;

public interface CommentService {
    Comment saveComment(Comment comment);

    void deleteComment(Long id);
}
