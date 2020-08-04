package com.ron.springboot_jpa.service;

import com.ron.springboot_jpa.domain.Article;

public interface ArticleService {

    Article saveArticle(Article article);

    Article updateArticle(Article article);

    Article findArticle(Long id);

    void deleteArticle(Long id);
}
