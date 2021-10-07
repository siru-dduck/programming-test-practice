package kakao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 2021 카카오 채용연계형 인턴십 - 숫자 문자열과 영단어
 * @link{https://programmers.co.kr/learn/courses/30/lessons/81301}
 */
class NumericStringEnglishWordTest {

    private final NumericStringEnglishWord numericStringEnglishWord;

    public NumericStringEnglishWordTest() {
        this.numericStringEnglishWord = new NumericStringEnglishWord();
    }

    @Test
    void solution() {
        // given
        String s1 = "one4seveneight";
        String s2 = "23four5six7";

        // when
        int result1 = numericStringEnglishWord.solution(s1);
        int result2 = numericStringEnglishWord.solution(s2);

        // then
        Assertions.assertEquals(1478, result1);
        Assertions.assertEquals(234567, result2);
    }
}