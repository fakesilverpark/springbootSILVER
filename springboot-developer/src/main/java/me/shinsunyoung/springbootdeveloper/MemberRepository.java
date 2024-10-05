package me.shinsunyoung.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 레포지토리는 엔티티에 있는 데이터를 조회, 저장, 변경, 삭제 할 때 사용하는 인터페이스
// 스프링 데이터 JPA 에서 제공하는 인터페이스인 JpaRepository 클래스를 상속받아 간단하게 구현가능
// JpaRepository 클래스를 상속받을때 엔티티 Member 와 엔티티의 기본키 타입 Long 을 인수로 넣어줌
// 이제 해당 레포지토리를 사용할 때 JpaRepository 에서 제공하는 여러메서드 사용 가능
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);
}