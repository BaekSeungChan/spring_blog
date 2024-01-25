package com.example.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    // 게더
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "title" , nullable = false)
    public String title;

    @Column(name = "content", nullable = false)
    public String content;

    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

}
