package com.ron.springboot_jpa;

import com.alibaba.fastjson.JSON;
import com.ron.springboot_jpa.domain.Author;
import com.ron.springboot_jpa.domain.AuthorRepository;
import com.ron.springboot_jpa.domain.Wallet;
import com.ron.springboot_jpa.domain.WalletRepository;
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
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private AuthorService authorService;

    @Test
    public void saveAuthorTest() {
        Author author = new Author();
        author.setNickName("Ron");
        author.setPhone("0969858321");
        author.setSignDate(new Date());
        author.setWallet(new Wallet(new BigDecimal(181.23)));

        authorRepository.save(author);
    }

    @Test
    public void updateAuthor() {
        Author author = authorService.findAuthor(13L);
        author.setPhone("123456");
        Wallet wallet = author.getWallet();
        wallet.setBalance(new BigDecimal(999.68));
        author.setWallet(wallet);

        authorService.updateAuthor(author);
    }

    @Test
    public void findAuthorTest() {
        Author author = authorService.findAuthor(13L);
        System.out.println(JSON.toJSONString(author, true));
    }

    @Test
    public void deleteAuthorTest() {
        authorService.deleteAuthor(13L);
    }

//    @Test
//    public void findAuthorTest() {
////        List<Author> authors = authorRepository.findByPhoneAndNickName("123456", "Ron");
////        List<Author> authors = authorRepository.findDistinctByNickNameIgnoreCaseOrPhoneOrderBySignDateDesc("Ron", "123456");
////        List<Author> authors = authorRepository.findByNickNameLike("%Ro%");
////        List<Author> authors = authorRepository.findByPhone("67");
////        List<Object[]> arry = authorRepository.findArry("T");
////        List<Author> authors = authorRepository.findByNickName("o",Sort.by(Sort.Direction.DESC, "signDate"));
////        List<Author> authors = authorRepository.findBySql("o");
////        int i = authorRepository.setNickName("Xp", "1234567");
//
////        System.out.println(JSON.toJSONString(authors,true));
//    }

    @Test
    public void findAuthorForPageTest() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(1, 2, sort);
        Page<Author> page = authorRepository.findAll(pageable);

        System.out.println(JSON.toJSONString(page, true));
    }

    @Test
    public void transactionalTest() {
        authorService.updateAuthor();
    }

    @Test
    public void findWalletTest() {
        Wallet wallet = walletRepository.findById(2L).orElse(null);
        System.out.println(JSON.toJSONString(wallet,true));
    }
}
