package dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 백준(동적프로그래밍) - 피보나치 함수
 * @link{https://www.acmicpc.net/problem/1003}
 */
class FibonacciTest {

    private final Fibonacci fibonacci;

    public FibonacciTest() {
        this.fibonacci = new Fibonacci();
    }

    @Test
    @DisplayName("피보나치 함수 테스트")
    void solution() {
        // given
        int n1 = 0;
        int n2 = 1;
        int n3 = 3;

        // when
        String result1 = fibonacci.solution(n1);
        String result2 = fibonacci.solution(n2);
        String result3 = fibonacci.solution(n3);
        
        // then
        Assertions.assertEquals("1 0", result1);
        Assertions.assertEquals("0 1", result2);
        Assertions.assertEquals("1 2", result3);
    }
}