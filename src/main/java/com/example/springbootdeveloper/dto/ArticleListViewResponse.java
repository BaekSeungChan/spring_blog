package com.example.springbootdeveloper.dto;

import com.example.springbootdeveloper.domain.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleListViewResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createAt;


    public ArticleListViewResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createAt = article.getCreateAt();

    }
}
