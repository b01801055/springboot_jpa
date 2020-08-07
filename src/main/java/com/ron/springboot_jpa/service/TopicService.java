package com.ron.springboot_jpa.service;

import com.ron.springboot_jpa.domain.Topic;

public interface TopicService {

    Topic saveTopic(Topic topic);

    Topic findTopic(Long id);

    Topic updateTpoic(Topic topic);

    Topic includeArticle(Long topicId, Long articleId);

    Topic unIncludeArticle(Long topicId, Long articleId);

    void deleteTopic(Long id);
}
