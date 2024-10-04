import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    @DisplayName("1 + 2 is 3") // test name
    @Test // 이 애너테이션을 붙인 메서드는 테스트를 수행하는 메서드가 된다

    // junit 은 테스트끼리 영향을 주지 않도록 각 테스트를 실행할 때마다 테스트를 위한 실행 객체를 만들고
    // 테스트가 종료되면 실행 객체를 삭제
    public void junitTest(){
        int a = 1;
        int b = 2;
        int sum = 3;

        Assertions.assertEquals(sum, a + b); // 값이 같은지 확인
    }

    @DisplayName("1 + 3 is 4")
    @Test

    public void junitFailedTest(){
        int a = 1;
        int b = 3;
        int sum = 3;

        Assertions.assertEquals(sum, a + b); // 실패하는 케이스
    }
}

/*
    코드 설명
    junit 에서 제공하는 검증 메서드인 assertEquals() 로 a + b 와 sum 의 값이 같은 지 확인
    assertEquals() 메서드의 첫번째 인수는 기대하는 값, 두번째 인수에는 실제로 검증할 값
 */