package com.ron.springboot_jpa;

import com.alibaba.fastjson.JSON;
import com.ron.springboot_jpa.domain.Article;
import com.ron.springboot_jpa.domain.Comment;
import com.ron.springboot_jpa.service.ArticleService;
import com.ron.springboot_jpa.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTests {

   @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Test
    public void saveCommentTest() {
        Article article = articleService.findArticle(13L);

        Comment comment = new Comment();
        comment.setContent("rgrewwefwf");
        comment.setArticle(article);

        commentService.saveComment(comment);
    }

    @Test
    public void deleteCommentTest() {
        commentService.deleteComment(11L);
    }
}
