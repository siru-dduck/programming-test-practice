package dynamicProgramming;

public class RoadToSchool {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];

        for (int[] puddle : puddles) {
            dp[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        for (int i = 1; i < m; i++) {
            if(dp[i][0] == -1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if(dp[0][i] == -1) {
                break;
            }
            dp[0][i] = 1;
        }


        if(dp[0][1] == -1 && dp[1][0] == -1) {
            return 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[j][i] == -1) {
                    continue;
                }
                int top = dp[j][i - 1] == -1 ? 0 : dp[j][i - 1];
                int left = dp[j - 1][i] == -1 ? 0 : dp[j - 1][i];
                dp[j][i] = (top + left) % 1000000007;
            }
        }


        return dp[m - 1][n - 1] % 1000000007;
    }

}
