package me.shinsunyoung.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자
@AllArgsConstructor
@Getter
@Entity // 엔티티로 지정
public class Member {
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false) // name 이라는 not null 칼럼과 매핑
    private String name;

    // 이 메서드는 @Transactional 어노테이션이 포함된 메서드에서 호출되면
    // JPA 는 변경 감지 (dirty checking) 기능을 통해 엔티티의 필드값이 변경될 때 그 변경사항을 디비에 자동으로 반영
    // 만약 엔티티가 영속 상태일 때 필드값을 변경하고 트랜잭션이 커밋되면 JPA 는 변경사항을 디비에 자동 적용
    public void changeName(String name) {
        this.name = name;
    }
}

/*
    추가 설명
        - @Entity
            : Member 라는 객체를 JPA 가 관리하는 엔티티로 지정
                즉, Member 클래스와 실제 디비의 테이블을 매핑시킴
                @Entity 의 속정 중에 name 을 사용하면 name 의 값을 가진 테이블 이름과 매핑되고
                테이블 이름을 지정하지 않으면 클래스 이름과 같은 이름의 테이블과 매핑됨
                여기서는 테이블 이름을 지정하지 않았으므로 클래스 이름과 같은 디비 테이블인 member 테이블과 매핑됨
                @Entity 어노테이션에서 테이블을 지정하고 싶다면 @Entity(name = "member_list") // member_list 라는 이름을 가진 테이블과 매핑
                이렇게 name 파라미터에 값을 지정해준다

        - @NoArgsConstructor(access = AccessLevel.PROTECTED)
            : 기본 생성자를 protected 로 설정
                엔티티는 반드시 기본 생성자가 있어야 하고, 접근 제어자는 public 또는 protected 여야한다.
                protected 가 더 안전하므로 접근제어자가 protected 인 기본 생성자를 생성

        - @Id
            : Long 타입의 id 필드를 테이블의 기본키로 지정

        - @GeneratedValue
            : 기본키 생성방식 결정 (여기서는 자동으로 기본키가 증가되게 설정)

            - AUTO : 선택한 디비 방언에 따라 방식을 자동으로 선택
            - IDENTITY : 기본키 생성을 디비에 위임 (= AUTO INCREMENT)
            - SEQUENCE : 디비 시퀀스를 사용해 기본키 할당 (주로 오라클에서 사용)
            - TABLE : 키 생성 테이블 사용

        - @Column
            : 디비의 칼럼과 필드를 매핑해준다

            - name :  필드와 매핑할 칼럼 이름. 설정하지 않으면 필드 이름으로 지정
            - nullable : 칼럼의 null 허용 여부. 설정하지 않으면 true (nullable)
            - unique : 칼럼의 유일한 값 여부. 설정하지 않으면 false (non-unique)
            - columnDefinition : 칼럼 정보 설정. default 값을 줄 수 있음
 */
