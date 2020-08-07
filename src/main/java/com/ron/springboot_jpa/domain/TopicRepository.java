package com.ron.springboot_jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {
}
