package dynamicProgramming;

import java.io.*;

public class Fibonacci {

    public String solution(int N) {
        int[] count0 = new int[N + 1];
        int[] count1 = new int[N + 1];
        if (N == 0) {
            return "1 0";
        } else if (N == 1) {
            return "0 1";
        } else {
            count0[0] = 1;
            count0[1] = 0;
            count1[0] = 0;
            count1[1] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            count0[i] = count0[i - 1] + count0[i - 2];
            count1[i] = count1[i - 1] + count1[i - 2];
        }
        return count0[N] + " " + count1[N];
    }

    public static void main(String[] args) throws IOException {
        Fibonacci fibonacci = new Fibonacci();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            String result = fibonacci.solution(Integer.parseInt(reader.readLine()));
            writer.write(result + "\n");
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}
