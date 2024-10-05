package me.shinsunyoung.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // 이 메서드는 @Transactional 어노테이션이 포함된 메서드에서 호출되면
    // JPA 는 변경 감지 (dirty checking) 기능을 통해 엔티티의 필드값이 변경될 때 그 변경사항을 디비에 자동으로 반영
    // 만약 엔티티가 영속 상태일 때 필드값을 변경하고 트랜잭션이 커밋되면 JPA 는 변경사항을 디비에 자동 적용
    public void changeName(String name) {
        this.name = name;
    }
}
