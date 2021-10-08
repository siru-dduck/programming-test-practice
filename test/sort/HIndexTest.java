package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 프로그래머스(정렬) - H-Index
 *
 * @link{https://programmers.co.kr/learn/courses/30/lessons/42747}
 */
class HIndexTest {

    private final HIndex hIndex = new HIndex();

    @Test
    void solution() {

        // given
        int[] citations1 = {3, 0, 6, 1, 5};

        // when
        int result1 = hIndex.solution(citations1);

        // then
        Assertions.assertEquals(3, result1);

    }
}