package com.example.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
public class Article {
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    public Long id; // 기본키를 자동으로 1씩 증가

    @Column(name = "title", nullable = false) // 'title'이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content" ,nullable = false)
    private String content;

    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    protected Article(){
        // 빌더 패턴으로 객체 생성
    }


    // 게터
    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }
}
