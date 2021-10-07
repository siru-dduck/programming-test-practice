package dynamicProgramming;

import java.io.*;

public class ExcitingMethodRun {

    public int solution(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);

        if(min < 1) {
            return 1;
        } else if (max > 20) {
            return 1048576;
        }

        int[][][] dp = new int[max + 1][max + 1][max + 1];


        for (int i = 0; i < max + 1; i++) {
            for (int j =0; j < max + 1; j++) {
                for (int k = 0; k < max + 1; k++) {
                    if(i <= 0 || j <= 0 || k <= 0) {
                        dp[i][j][k] = 1;
                    } else if(i < j && j < k) {
                        dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
                    } else {
                        dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
                    }
                }
            }
        }

        return dp[a][b][c];
    }

    public static void main(String[] args) throws IOException {
        ExcitingMethodRun excitingMethodRun = new ExcitingMethodRun();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] numStrList = line.split(" ");
            int a = Integer.parseInt(numStrList[0]);
            int b = Integer.parseInt(numStrList[1]);
            int c = Integer.parseInt(numStrList[2]);
            if(a == -1 && b == -1 && c == -1) {
                break;
            }
            int result = excitingMethodRun.solution(a, b, c);

            writer.write(String.format("w(%d, %d, %d) = %d\n", a, b, c, result));
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}
