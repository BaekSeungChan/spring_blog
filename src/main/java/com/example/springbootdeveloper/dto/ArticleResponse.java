package com.example.springbootdeveloper.dto;

import com.example.springbootdeveloper.domain.Article;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class ArticleResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt; // 필드 추가

    // 생성자에 createAt 파라미터 추가
    public ArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createAt = article.getCreateAt(); // Article 엔티티의 createAt 값을 설정
    }
}
