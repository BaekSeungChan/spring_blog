package com.example.springbootdeveloper.controller;

import com.example.springbootdeveloper.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 테스트용 애플리케이션 컨텍스트
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class BlogApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // 직렬화, 역직렬화를 위한 클래스

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BlogRepository blogRepository;


    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();

        blogRepository.deleteAll();
    }

    //context 변수가 MockMvcBuilders.webAppContextSetup 메서드에 전달되는 이유는, 테스트 환경을 실제 애플리케이션 컨텍스트와 일치시키기 위함입니다.
    // 이렇게 함으로써, 테스트는 실제 애플리케이션과 동일한 환경에서 실행되며, 실제 애플리케이션의 설정, 빈(Bean) 구성, MVC 설정 등을 그대로 사용할 수 있습니다.


}