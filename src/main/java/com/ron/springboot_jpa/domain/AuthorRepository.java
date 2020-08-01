package com.ron.springboot_jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findByPhoneAndNickName(String phone, String nickName);
}
