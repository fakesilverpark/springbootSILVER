import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Test
public void junitTest(){
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