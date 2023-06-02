package com.spring.shortenUrl.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ShortenUrlRepository {
    int save(String url);

    String findByShortenUrl(int sq);


}
