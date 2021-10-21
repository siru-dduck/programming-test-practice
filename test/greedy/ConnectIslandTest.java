package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 프로그래머스 그리디 섬 연결하기
 * @link{https://programmers.co.kr/learn/courses/30/lessons/42861}
 */
class ConnectIslandTest {

    private final ConnectIsland connectIsland = new ConnectIsland();

    @Test
    void 섬_연결하기_테스트() throws Exception {
        // given
        int n1 = 5;
        int[][] costs1 = {{0, 1, 1}, {0, 4, 5}, {2, 4, 1}, {2, 3, 1}, {3, 4, 1}};

        int n2 = 4;
        int[][] costs2 = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        int n3 = 5;
        int[][] costs3 = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}};

        // when
        int result1 = connectIsland.solution(n1, costs1);
        int result2 = connectIsland.solution(n2, costs2);
        int result3 = connectIsland.solution(n3, costs3);

        // then
        Assertions.assertEquals(8, result1);
        Assertions.assertEquals(4, result2);
        Assertions.assertEquals(15, result3);
    }
}