package math;

import java.io.*;

public class BaseConversion2 {

    public String solution(int N, int B) {
        StringBuffer buffer = new StringBuffer();
        while (N >= B) {
            int mode = N % B >= 10 ? 'A' + (N % B - 10) : '0' + N % B;
            buffer.insert(0, Character.valueOf((char) mode));
            N = N / B;
        }
        int mode = N >= 10? 'A' + (N - 10) : '0' + N;
        buffer.insert(0, Character.valueOf((char) mode));
        return buffer.toString();
    }

    public static void main(String[] args) throws IOException {
        BaseConversion2 baseConversion2 = new BaseConversion2();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        String result = baseConversion2.solution(N, B);

        writer.write(result);
        writer.flush();
        reader.close();
        writer.close();
    }

}
