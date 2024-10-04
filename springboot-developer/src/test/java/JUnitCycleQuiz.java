import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitCycleQuiz {

    @BeforeEach
    public void junitQUiz1() {
        System.out.println("Hello!");
    }

    @AfterAll
    public static void junitQUiz2() {
        System.out.println("Bye!");
    }

    @Test
    public void junitQuiz3() {
        System.out.println("this is first test");
    }

    @Test
    public void junitQuiz4() {
        System.out.println("this is second test");
    }

    /*
        answer:
            Hello!
            this is first test
            Hello!
            this is second test
            Bye!
     */
}