import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Test
public void junitTest1(){
    String name1 = "sally";
    String name2 = "sally";
    String name3 = "millie";

    // 모든 변수가 null 이 아닌지 확인
    assertThat(name1).isNotNull();
    assertThat(name2).isNotNull();
    assertThat(name3).isNotNull();

    // name1 과 name2 가 같은지 확인
    assertThat(name1).isEqualTo(name2);

    // name1 과 name3 가 다른지 확인
    assertThat(name1).isNotEqualTo(name3);
}

@Test
public void junitTest2(){
    int num1 = 15;
    int num2 = 0;
    int num3 = -5;

    // num1 이 양수인지
    assertThat(num1).isPositive();

    // num2 가 0 인지
    assertThat(num2).isEqualTo(0); // isZero()

    // num3 가 음수인지
    assertThat(num3).isNegative();

    // num1 이 num2 보다 큰지
    assertThat(num1).isGreaterThan(num2);

    // num3 가 num2 보다 작은지
    assertThat(num3).isLessThan(num2);
}