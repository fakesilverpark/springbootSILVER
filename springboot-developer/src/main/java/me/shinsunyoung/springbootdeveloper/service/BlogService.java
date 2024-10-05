package me.shinsunyoung.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Article;
import me.shinsunyoung.springbootdeveloper.dto.AddArticleRequest;
import me.shinsunyoung.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
    /*
        @RequiredArgsConstructor
            : 빈을 생성자로 생성하는 롬복에서 지원하는 어노테이션
            final 이나 @NotNull 이 붙은 필드의 생성자 추가
     */

@Service // 해당 클래스를 빈으로 서블릿 컨테이너에 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    /*
        save()
            : 이 메서드는 JpaRepository 에서 지원하는 저장 메서드 save() 로
            AddArticleRequest 클래스에 저장된 값을 article 디비에 저장
     */
}