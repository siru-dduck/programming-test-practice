package sort;

import java.util.Arrays;

public class SteppingStone {

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int[] rockList = new int[rocks.length + 2];
        Arrays.sort(rocks);
        rockList[0] = 0;
        rockList[rockList.length - 1] = distance;
        System.arraycopy(rocks, 0, rockList, 1, rocks.length);

        if(rocks.length == n) {
            return distance;
        }

        int left = 1;
        int right = distance;
        while (left <= right) {
            int mid = (left + right) / 2;
            int removeCnt = 0;
            for (int i = 0; i < rockList.length - 1; i++) {
                for (int j = i + 1; j < rockList.length; j++) {
                    if (rockList[j] - rockList[i] < mid) {
                        removeCnt++;
                    } else {
                        i = j-1;
                        break;
                    }
                }
            }

            if(removeCnt <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return  answer;
    }

}
