package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// 학습 테스트 : 기능 구현을 위한 테스트가 아닌 사용하는 라이브러리, 프레임워크에서 지원하는 기능을 검증하며 어떻게 동작하는지 파악하기위한 테스트

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-member.sql") // 테스트 실행 전 sql 스크립트 실행 시킴 (멤버 생성 쿼리문을 실행하고 조회가 잘되는지 본다)
    @Test
    void getAllMembers(){
        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members.size()).isEqualTo(3);
    }

    @Sql("/insert-member.sql")
    @Test
    void getMemberById(){
        // when
        Member member = memberRepository.findByName("C").get();

        // then
        assertThat(member.getId()).isEqualTo(3);
    }

    @Test
    void saveMember(){
        // given : A 멤버 객체 준비
        Member member = new Member(1L, "A");

        // when : 실제로 저장
        memberRepository.save(member);

        // then : 1번 아이디에 해당하는 멤버의 이름을 가져옴 (조회 단계와 다르게 이미 추가된 데이터가 있으면 안되어서 @Sql 어노테이션은 안사용한다
        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");
    }

    // 여러 엔티티를 한번에 저장할 때
    @Test
    void saveMembers(){
        // given
        List<Member> members = List.of(new Member(2L, "B"), new Member(3L, "C"));

        // when
        memberRepository.saveAll(members);

        // then
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }

    // 멤버 삭제
    @Sql("/insert-member.sql")
    @Test
    void deleteMemberById(){
        // when
        memberRepository.deleteById(2L);

        // then
        assertThat(memberRepository.findById(2L).isEmpty()).isTrue();
    }

    // 모든 데이터 삭제하기 : 모든 데이터를 삭제하므로 실제 서비스 코드에서는 거의 사용되지 않고 테스트 간의 격리를 보장하기 위해 사용된다 (즉, 한 테스트의 실행으로 디비가 변경되었을때 다른 테스트가 그 디비를 사용할 때 영향을 안주게 하려고)
    // 그래서 보통은 @AfterEach 어노테이션을 붙여 cleanUp() 메서드와 같은 형태로 사용
    @Sql("/insert-member.sql")
    @Test
    void deleteAll(){
        // when
        memberRepository.deleteAll();

        // then
        assertThat(memberRepository.findAll().size()).isZero();
    }

    /*
        정리
        - save() : 레코드 추가
        - saveAll() : 한꺼번에 여러 레코드 추가
        - deleteById() : 아이디로 레코드 삭제
        - deleteAll() : 모든 레코드 삭제
     */
}