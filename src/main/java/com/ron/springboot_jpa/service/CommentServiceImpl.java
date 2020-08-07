package com.ron.springboot_jpa.service;

import com.ron.springboot_jpa.domain.Comment;
import com.ron.springboot_jpa.domain.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        comment.clearComment();
//        List<Comment> comments = comment.getArticle().getComments();
//        for (Comment comment1 : comments) {
//            if (id == comment1.getId()) {
//                comments.remove(comment1);
//                break;
//            }
//        }
//        commentRepository.deleteById(id);
        commentRepository.deleteBy(id);
    }

}
