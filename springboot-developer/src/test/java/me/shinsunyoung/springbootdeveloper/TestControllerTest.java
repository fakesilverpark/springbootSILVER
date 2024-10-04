package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    public void cleanup() {
        memberRepository.deleteAll();
    }
}

/*
    애너테이션 설명
        - SpringBootTest
            : 메인 애플리케이션 클래스에 추가하는 애너테이션인 @SpringBootApplication 이 있는
            클래스를 찾아서 그 클래스에 포함되어 있는 빈을 찾은 다음 테스트용 애플리케이션 컨텍스트
            라는 걸 만든다

        - AutoConfigureMockMvc
            : MockMvc 를 생성하고 자동 구성하는 애너테이션
            MockMvc 는 애플리케이션을 서버에 배포하지 않고도 테스트용 Mvc 환경을 만들어
            요청, 전송, 응답 기능을 제공하는 유틸리티 서비스 -> 즉 컨트롤러 테스트 시 사용되는 클래스
 */