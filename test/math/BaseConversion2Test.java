package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseConversion2Test {

    private final BaseConversion2 baseConversion2 = new BaseConversion2();

    @Test
    void solution() {
        // given
        int N1 = 60466175;
        int B1 = 36;
        
        // when
        String result1 = baseConversion2.solution(N1, B1);

        // then
        Assertions.assertEquals("ZZZZZ", result1);
    }
}