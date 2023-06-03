package com.spring.shortenUrl.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ShortenUrlRepositoryImp implements ShortenUrlRepository{
    private static final Map<String, String> urlList = new HashMap<>();
    private final int RADIX = 62;
    private static final char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    @Override
    public String save(String url) {
        //base 62 인코딩
        Random rnd = new Random();
        long sq = Math.abs(rnd.nextLong() % 10000000000L);
        StringBuilder sb = new StringBuilder();

        do {
            int i = (int)(sq % RADIX);
            sb.append(BASE62[i]);
            sq /= RADIX;
        } while (sq > 0);

        //인코딩된 문자열을 key 값으로 url과 함께 저장
        urlList.put(sb.toString(),url);

        //저장 완료 후 키값 리턴
        return sb.toString();
    }

    @Override
    public String findByShortenUrl(String shortenUrl) {
        return urlList.get(shortenUrl);
    }
}
