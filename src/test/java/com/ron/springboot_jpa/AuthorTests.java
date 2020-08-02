package com.ron.springboot_jpa;

import com.alibaba.fastjson.JSON;
import com.ron.springboot_jpa.domain.Author;
import com.ron.springboot_jpa.domain.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void saveAuthorTest() {
        Author author = new Author();
        author.setNickName("Ron");
        author.setPhone("123456");
        author.setSignDate(new Date());
        authorRepository.save(author);
    }

    @Test
    public void findAuthorTest() {
//        List<Author> authors = authorRepository.findByPhoneAndNickName("123456", "Ron");
//        List<Author> authors = authorRepository.findDistinctByNickNameIgnoreCaseOrPhoneOrderBySignDateDesc("Ron", "123456");
//        List<Author> authors = authorRepository.findByNickNameLike("%Ro%");
//        List<Author> authors = authorRepository.findByPhone("67");
//        List<Object[]> arry = authorRepository.findArry("T");
//        List<Author> authors = authorRepository.findByNickName("o",Sort.by(Sort.Direction.DESC, "signDate"));
//        List<Author> authors = authorRepository.findBySql("o");
        int i = authorRepository.setNickName("Xp", "1234567");

//        System.out.println(JSON.toJSONString(authors,true));
    }
}
