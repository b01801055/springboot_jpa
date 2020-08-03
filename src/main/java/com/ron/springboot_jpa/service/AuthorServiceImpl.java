package com.ron.springboot_jpa.service;

import com.ron.springboot_jpa.domain.Author;
import com.ron.springboot_jpa.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public Author updateAuthor() {

        Author author = new Author();
        author.setPhone("987654");
        author.setNickName("god");
        author.setSignDate(new Date());
        Author author1 = authorRepository.save(author);

        author1.setPhone("789456");
        Author author2 = authorRepository.save(author1);

        return author2;
    }
}
