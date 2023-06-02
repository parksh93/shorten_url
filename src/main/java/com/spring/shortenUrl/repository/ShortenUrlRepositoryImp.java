package com.spring.shortenUrl.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ShortenUrlRepositoryImp implements ShortenUrlRepository{
    private static final Map<Integer, String> urlList;
    private static int sq;

    static {
        urlList = new HashMap<>();
        urlList.put(++sq,"https://n.news.naver.com/article/014/0005021732?cds=news_media_pc&type=editn");
    }

    @Override
    public int save(String url) {
        urlList.put(++sq,url);
        return sq;
    }

    @Override
    public String findByShortenUrl(int sq) {
        return urlList.get(sq);
    }
}
