package com.spring.shortenUrl.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShortenUrlRepositoryTest {
    @Autowired
    ShortenUrlRepository shortenUrlRepository;

    @Test
    @DisplayName("저장 후 성공적으로 리턴되었는지 확인")
    public void saveTest(){
        //given 없음

        //when
        String url = "https://n.news.naver.com/article/087/0000974387?cds=news_media_pc&type=editn";

        //then
        assertNotNull(shortenUrlRepository.save(url));
    }

    @Test
    @DisplayName("url을 저장 후 리턴된 단축url이 null이 아닌지 검사")
    public void findByShortenUrlTest(){
        //given
        String inUrl = "https://n.news.naver.com/article/087/0000974387?cds=news_media_pc&type=editn";
        String sq = shortenUrlRepository.save(inUrl);

        //when
        String url = shortenUrlRepository.findByShortenUrl(sq);

        //then
        assertNotNull(url);
    }

}
