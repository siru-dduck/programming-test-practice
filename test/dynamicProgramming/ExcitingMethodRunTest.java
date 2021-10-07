package dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 백준(다이나믹프로그래밍) - 신나는 함수 실행
 * @link{https://www.acmicpc.net/problem/9184}
 */
class ExcitingMethodRunTest {

    private final ExcitingMethodRun excitingMethodRun;

    public ExcitingMethodRunTest() {
        this.excitingMethodRun = new ExcitingMethodRun();
    }

    @Test
    void solution() {
        // given
        int a1 = 1, b1 = 1, c1 = 1;
        int a2 = 2, b2 = 2, c2 = 2;
        int a3 = 10, b3 = 4, c3 = 6;
        int a4 = 50, b4 = 50, c4 = 50;
        int a5 = -1, b5 = 7, c5 = 8;

        // when
        int result1 = excitingMethodRun.solution(a1, b1, c1);
        int result2 = excitingMethodRun.solution(a2, b2, c2);
        int result3 = excitingMethodRun.solution(a3, b3, c3);
        int result4 = excitingMethodRun.solution(a4, b4, c4);
        int result5 = excitingMethodRun.solution(a5, b5, c5);

        // then
        Assertions.assertEquals(2, result1);
        Assertions.assertEquals(4, result2);
        Assertions.assertEquals(523, result3);
        Assertions.assertEquals(1048576, result4);
        Assertions.assertEquals(1, result5);
    }
}