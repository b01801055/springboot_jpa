package com.ron.springboot_jpa.service;

import com.ron.springboot_jpa.domain.Author;

public interface AuthorService {
    Author updateAuthor();

    Author saveAuthor(Author author);

    Author updateAuthor(Author author);

    Author findAuthor(Long id);

    void deleteAuthor(Long id);
}
