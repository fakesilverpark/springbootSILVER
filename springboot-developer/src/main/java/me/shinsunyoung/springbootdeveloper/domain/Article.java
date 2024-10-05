package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
@Entity // 엔티티로 지정
public class Article {

    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // title 이라는 not null 칼럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder // 빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    protected Article() {} // 기본 생성자

    // 게터
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
*/

/*
    @Builder
        : 롬복에서 지원하는 어노테이션, 이 어노테이션을 생성자 위에 입력하면 빌더 패턴 방식으로 객체 생성 가능

        * 빌더 패턴: 객체를 유연하고 직관적으로 생성할 수 있어서 개발자들이 애용하는 디자인 패턴
        빌더 패턴을 사용하면 어느 필드에 어느 값이 들어가는지 명시적으로 파악이 가능

        ex -
            // 빌더 패턴 사용 X
            new Article("abc", "def");

            // 빌더 패턴 사용 O
            Article.builder()
                .title("abc")
                .content("def")
                .build();

            빌더 패턴을 사용하지 않으면 각 값이 어느 필드에 들어가는 값인지 파악이 안되지만,
            빌더 패턴을 사용하면 어느 필드에 어느 값이 매칭되는지 바로 보여서 객체 생성 코드의 가독성이 높아짐
            그리고 이 어노테이션을 사용하면 발더 패턴 사용을 위한 코드를 자동으로 생성해서 간편하게 빌더 패턴을 사용해 객체를 만들 수 있다
 */

/*----------------------------------------------------------------------------*/

// lombok 으로 코드 개선
// getId() 같은 필드 값을 가져오는 메서드들을 public class Article 위에 @Getter, @NoArgsConstructor 로 대체

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id // id 필드 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // title 이라는 not null 칼럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /*
        @NoArgsConstructor
            : 어노테이션을 선언해 접근 제어자가 protected 인 기본 생성자를 별도의 코드 없이 생성

        @Getter
            : 클래스 필드에 대해 별도 코드 없이 모든 필드에 대한 접근자 메서드를 만듦

        --> 이렇게 롬복 애너테이션을 사용해 코드의 반복을 줄여서 가독성이 향상되었다!!!
     */
}