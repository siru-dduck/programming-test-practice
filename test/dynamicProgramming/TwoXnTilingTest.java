package dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 프로그래머스 연습문제 - 2 x n 타일링
 * @link{https://programmers.co.kr/learn/courses/30/lessons/12900}
 */
class TwoXnTilingTest {

    private final TwoXnTiling twoXnTiling = new TwoXnTiling();

    @Test
    void solution() {
        // given
        int n1 = 4;

        // when
        int result1 = twoXnTiling.solution(n1);

        // then
        Assertions.assertEquals(5, result1);
    }
}