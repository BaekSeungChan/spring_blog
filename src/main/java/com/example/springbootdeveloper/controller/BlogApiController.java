package com.example.springbootdeveloper.controller;

import com.example.springbootdeveloper.domain.Article;
import com.example.springbootdeveloper.dto.AddArticleRequest;
import com.example.springbootdeveloper.dto.ArticleResponse;
import com.example.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
@RequestMapping("/api")
public class BlogApiController{

    private final BlogService blogService;

    // HTTP 메서드가 POST일 때 전달 받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/articles")
    // @RequestBody로 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article saveArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveArticle);
    }

    @GetMapping("/articles/get")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findById(id);

        return ResponseEntity.ok().body(new ArticleResponse(article));
    }
}
