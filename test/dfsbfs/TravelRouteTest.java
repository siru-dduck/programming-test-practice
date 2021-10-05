package dfsbfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 프로그래머스 깊이/너비 우선 탐색(DFS/BFS) - 여행경로 level3
 *
 * @link{https://programmers.co.kr/learn/courses/30/lessons/43164}
 */
class TravelRouteTest {

    private final TravelRoute travelRoute;

    public TravelRouteTest() {
        travelRoute = new TravelRoute();
    }

    @Test
    @DisplayName("여행경로 테스트")
    void solution() {
        // given
        String[][] ticket1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] ticket2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[][] ticket3 = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
        String[][] ticket4 = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};

        // when
        String[] result1 = travelRoute.solution(ticket1);
        String[] result2 = travelRoute.solution(ticket2);
        String[] result3 = travelRoute.solution(ticket3);
        String[] result4 = travelRoute.solution(ticket4);

        // then
        Assertions.assertArrayEquals(new String[]{"ICN", "JFK", "HND", "IAD"}, result1);
        Assertions.assertArrayEquals(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}, result2);
        Assertions.assertArrayEquals(new String[]{"ICN", "SFO", "ICN", "SFO", "QRE"}, result3);
        Assertions.assertArrayEquals(new String[]{"ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"}, result4);
    }
}