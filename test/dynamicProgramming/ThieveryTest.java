package dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThieveryTest {

    @Test
    @DisplayName("도둑질 테스트 케이스 1")
    void solution() {
        // given
        Thievery thievery = new Thievery();
        int[] money1 = {1, 2, 3, 1, 5};
        int[] money2 = {1, 2, 3, 1};
        int[] money3 = {91, 90, 5, 7, 5, 7 };
        int[] money4 = {90, 0, 0, 95, 1, 1};

        // when
        int result1 = thievery.solution(money1);
        int result2 = thievery.solution(money2);
        int result3 = thievery.solution(money3);
        int result4 = thievery.solution(money4);

        // then
        Assertions.assertEquals(8, result1);
        Assertions.assertEquals(4, result2);
        Assertions.assertEquals(104, result3);
        Assertions.assertEquals(185, result4);
    }
}