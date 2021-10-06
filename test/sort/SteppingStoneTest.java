package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SteppingStoneTest {

    private final SteppingStone steppingStone;

    public SteppingStoneTest() {
        this.steppingStone = new SteppingStone();
    }

    @Test
    @DisplayName("징검다리 테스트")
    void solution() {
        // given
        int distance1 = 25;
        int[] rocks1 = {2, 14, 11, 21, 17};
        int n1 = 2;

        // when
        int result1 = steppingStone.solution(distance1, rocks1, n1);

        // then
        Assertions.assertEquals(4, result1);
    }
}