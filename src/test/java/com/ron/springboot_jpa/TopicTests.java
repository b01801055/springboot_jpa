package com.ron.springboot_jpa;

import com.alibaba.fastjson.JSON;
import com.ron.springboot_jpa.domain.Topic;
import com.ron.springboot_jpa.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTests {

    @Autowired
    private TopicService topicService;

    @Test
    public void saveTopic() {
        Topic topic = new Topic();
        topic.setName("藝術");
        topicService.saveTopic(topic);
    }

    @Test
    public void updateTopic() {
        Topic topic = topicService.findTopic(20L);
        topic.setName("文學");
        topicService.saveTopic(topic);
    }

    @Test
    public void includeArticle() {
        topicService.includeArticle(20L, 13L);
    }

    @Test
    public void findTopic() {
        Topic topic = topicService.findTopic(20L);
//        topic.getArticles();
//        System.out.println(JSON.toJSONString(topic, true));
    }

    @Test
    public void unIncludeArticle() {
        topicService.unIncludeArticle(20L, 13L);
    }

    @Test
    public void deleteTopic() {
        topicService.deleteTopic(20L);
    }
}
