package dynamicProgramming;

/**
 * 프로그래머스 동적프로그래밍 - 도둑질 level4
 *
 * @link{https://programmers.co.kr/learn/courses/30/lessons/42897}
 */
public class Thievery {

    public int solution(int[] money) {
        int sum1 = 0;
        int sum2 = 0;

        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];

        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < money.length-1; i++) {
           dp1[i] = Math.max(money[i] + dp1[i-2], dp1[i-1]);
        }

        dp2[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(money[i] + dp2[i-2], dp2[i-1]);
        }

        return Math.max(dp1[money.length-2], dp2[money.length-1]);
    }

}
