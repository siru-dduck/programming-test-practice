package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 프로그래머스 그리디 - 조이스틱 level2
 *
 * @link{https://programmers.co.kr/learn/courses/30/lessons/42860?language=java}
 */
class JoyStickTest {

    @Test
    @DisplayName("조이스틱 테스트")
    void solution() {
        // given
        JoyStick joyStick = new JoyStick();
        String input1 = "JEROEN";
        String input2 = "JAN";

        // when
        int result1 =  joyStick.solution(input1);
        int result2 =  joyStick.solution(input2);

        // then
        Assertions.assertEquals(56, result1);
        Assertions.assertEquals(23, result2);


    }

}