package dfsbfs;

import greedy.JoyStick;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 프로그래머스 깊이/너비 우선 탐색(DFS/BFS) - 단어 변환 level3
 *
 * @link{https://programmers.co.kr/learn/courses/30/lessons/43163}
 */
class WordConvertTest {

    @Test
    @DisplayName("단어 변환 테스트")
    void solution() {
        // given
        WordConvert wordConvert = new WordConvert();
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};

        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        // when
        int result1 =  wordConvert.solution(begin1, target1, words1);
        int result2 =  wordConvert.solution(begin2, target2, words2);

        // then
        Assertions.assertEquals(4, result1);
        Assertions.assertEquals(0, result2);
    }
}