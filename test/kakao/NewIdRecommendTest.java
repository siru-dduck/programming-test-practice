package kakao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 2021 KAKAO BLIND RECRUITMENT - 신규 아이디 추천
 *
 * @link{https://programmers.co.kr/learn/courses/30/lessons/72410}
 */
class NewIdRecommendTest {

    private final NewIdRecommend newIdRecommend;

    public NewIdRecommendTest() {
        newIdRecommend = new NewIdRecommend();
    }

    @Test
    @DisplayName("신규 아이디 추천 테스트")
    void solution() {
        // given
        String newId1 = "...!@BaT#*..y.abcdefghijklm";
        String newId2 = "z-+.^.";

        // when
        String result1 = newIdRecommend.solution(newId1);
        String result2 = newIdRecommend.solution(newId2);

        // then
        Assertions.assertEquals("bat.y.abcdefghi", result1);
        Assertions.assertEquals("z--", result2);
    }
}