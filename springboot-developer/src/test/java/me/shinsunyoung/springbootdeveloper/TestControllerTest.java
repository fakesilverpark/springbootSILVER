package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @DisplayName("getAllMembers: 아티클 조회에 성공")
    @Test
    public void getAllMembers() throws Exception {

        // given : 멤버 저장
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "sally"));

        // when : 멤버 리스트를 조회하는 API 호출
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));
        // perform() : 요청을 전송하는 역할을 하는 메서드, 결과로 ResultActions 객체를 받음
            // ResultActions 객체는 반환값을 검증하고 확인하는 andExpect() 메서드 제공
        //accept() : 요청을 보낼 때 무슨 타입으로 응답 받을지 결정하는 메서드 (여기서는 json 을 받는다고 명시)

        // then : 응답 코드가 200 OK 이고, 반환받은 값 중에
            // 0번째 요소의 id 와 name 이 저장된 값이 같은지 확인
        result
                .andExpect(status().isOk())

                // 응답의 0번째 값이 디비에 저장한 값과 같은지 확인
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
        // andExpect() : 메서드 응답을 검증
            // TestController 에서 만든 API 응답으로 OK(200) 을 반환하므로
            // 이에 해당하는 isOk 메서드를 사용해 응답 코드가 OK(200) 인지 확인
        // jsonPath("$[0].${필드명}") : 제이슨 응답값의 값을 가져오는 역할을 하는 메서드
            // 0번째 배열에 들어 있는 객체의 id, name 을 가져오고 저장된 값과 같은지 확인
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