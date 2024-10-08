package me.shinsunyoung.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;

@NoArgsConstructor //  기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity() { // 생성자를 사용해 객체 생성
        /*
            toEntity
                : 빌더 패턴을 사용해 DTO를 엔티티로 만들어주는 메서드
                ( 나중에 블로그 글을 추가할 때 저장할 엔티티로 변환하는 용도)
         */

        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}

/*
    DTO
        : 계층끼리 데이터를 교환하기 위해 사용하는 객체
        DTO 는 단순히 데이터를 옮기기 위해 사용하는 전달자 역할을 하는 객체 -> 별도의 비지니스 로직을 안포함
    DAO
        : 디비와 연결되고 데이터를 조회하고 수정하는 데 사용하는 객체라
        데이터 수정과 관련된 로직에 포함됨
 */