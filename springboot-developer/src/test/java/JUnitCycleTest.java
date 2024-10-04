import org.junit.jupiter.api.*;

public class JUnitCycleTest {

    @BeforeAll // 전체 테스트 시작 전 1회만 실행 -> static 으로 선언
    static void beforeAll(){
        System.out.println("@BeforeAll");
    }

    @BeforeEach // 테스트 케이스 시작 전 마다 실행
    public void beforeEach(){
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @AfterAll // 전체 테스트를 마치기 1회만 실행 -> static 선언
    static void afterAll(){
        System.out.println("@AfterAll");
    }

    @AfterEach // 테스트 케이스 종료 전마다 실행
    public void afterEach(){
        System.out.println("@AfterEach");
    }

    /*
    실행 결과:  (원래는 \n 이 한번씩이지만 이해를 돕기위해 추가로 작성)

    @BeforeAll{
            전체 테스트 시작 전에 처음으로 한 번만 실행
            - 디비를 연결해야하거나 테스트 환경 초기화시에 이용
            : 전체 테스트 실행 주기에서 한 번만 호출되어야 하므로 static 으로 선언 }

    @BeforeEach{
            테스트 케이스를 시작하기 전에 매번 실행
            - 테스트 메서드에 사용하는 객체를 초기화하거나 테스트에 필요한 값을 미리 넣을 때
            : 각 인스턴스에 대해 메서드를 호출해야 하므로 static 으로 선언하면 안됨 }
    test1
    @AfterEach{
            각 테스트 케이스를 종료하기 전 매번 실행
            - 테스트 이후에 특정 데이터를 삭제해야하는 경우 사용
            : @BeforeEach 과 마찬가지로 static 이 아니어야함 }

    @BeforeEach
    test2
    @AfterEach

    @BeforeEach
    test3
    @AfterEach

    @AfterAll{
            전체 테스트를 마치고 종료하기 전에 한번만 실행
            - 디비 연결 종료시나 공통적으로 사용하는 자원을 해제할 때 사용
            : 전체 테스트 실행 주기에서 한번만 호출되어야 하므로 static 으로 선언}
     */
}