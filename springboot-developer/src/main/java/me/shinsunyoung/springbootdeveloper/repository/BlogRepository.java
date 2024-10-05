package me.shinsunyoung.springbootdeveloper.repository;

import me.shinsunyoung.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 클래스를 상속받을 때 엔티티 Article 과 엔티티의 PK 타입 Long 을 인수로 넣음
// -> 이제 이 레포를 쓸 때 JpaRepository 에서 제공하는 여러 메서드 사용 가능
public interface BlogRepository extends JpaRepository<Article, Long> {

}