package com.ron.springboot_jpa.service;

import com.alibaba.fastjson.JSON;
import com.ron.springboot_jpa.domain.Article;
import com.ron.springboot_jpa.domain.ArticleRepository;
import com.ron.springboot_jpa.domain.Topic;
import com.ron.springboot_jpa.domain.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic findTopic(Long id) {
        Topic topic = topicRepository.findById(id).orElse(null);
        topic.getArticles();
        System.out.println(JSON.toJSONString(topic, true));
        return topic;
    }

    @Transactional
    @Override
    public Topic updateTpoic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic includeArticle(Long topicId, Long articleId) {
        Topic topic = topicRepository.findById(topicId).orElse(null);
        Article article = articleRepository.findById(articleId).orElse(null);
        topic.getArticles().add(article);
        return topic;
    }

    @Transactional
    @Override
    public Topic unIncludeArticle(Long topicId, Long articleId) {
        Topic topic = topicRepository.findById(topicId).orElse(null);
        Article article = articleRepository.findById(articleId).orElse(null);
        topic.getArticles().remove(article);
        return topic;
    }

    @Transactional
    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
