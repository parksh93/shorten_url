package com.spring.shortenUrl.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ShortenUrlRepositoryTest {
    @Autowired
    ShortenUrlRepository shortenUrlRepository;

    @Test
    public void saveTest(){
        String url = "https://n.news.naver.com/article/087/0000974387?cds=news_media_pc&type=editn";

        assertEquals(2,shortenUrlRepository.save(url));
    }

    @Test
    public void findByShortenUrlTest(){
        int sq = 1;

        String url = shortenUrlRepository.findByShortenUrl(sq);

        assertNull(url);
    }

}
