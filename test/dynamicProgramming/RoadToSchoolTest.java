package dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 동적프로그래밍 - 등굣길 level3
 *
 * @link{https://programmers.co.kr/learn/courses/30/lessons/42898}
 */
public class RoadToSchoolTest {

    @Test
    @DisplayName("등굣길 테스트")
    public void roadToSchoolTest() {
        // given
        RoadToSchool roadToSchool = new RoadToSchool();
        int m = 4;
        int n = 3;
        int[][] puddles = new int[][]{{2, 2}};

        // when
        int result = roadToSchool.solution(m, n, puddles);

        // then
        Assertions.assertEquals(4, result);
    }

}
