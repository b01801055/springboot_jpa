package com.ron.springboot_jpa;

import com.alibaba.fastjson.JSON;
import com.ron.springboot_jpa.domain.*;
import com.ron.springboot_jpa.service.ArticleService;
import com.ron.springboot_jpa.service.AuthorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTests {

   @Autowired
    private ArticleService articleService;

    @Test
    public void saveArticle() {
        Article article = new Article();
        article.setTitle("gggg");
        article.setContent("fvjdjvofivjdfovfd....");

        List<Comment> comments = new ArrayList<>();
        Comment comment1 = new Comment("評論1jj");
//        comment1.setArticle(article);
        Comment comment2 = new Comment("評論2jjj");
//        comment2.setArticle(article);
        article.addComment(comment1);
        article.addComment(comment2);
//        comments.add(comment1);
//        comments.add(comment2);

//        article.setComments(comments);
        articleService.saveArticle(article);
    }

    @Test
    public void updateArticle() {
        Article article = articleService.findArticle(13L);
        article.setContent("bad book");
        article.setTitle("tom boot");
        articleService.updateArticle(article);
    }

    @Test
    public void findArticle() {
        Article article = articleService.findArticle(13L);
        System.out.println(JSON.toJSONString(article,true));
    }

    @Test
    public void deleteArticle() {
        articleService.deleteArticle(16L);
    }
}
