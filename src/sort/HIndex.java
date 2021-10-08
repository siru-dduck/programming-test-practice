package sort;

import java.util.Arrays;

public class HIndex {

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int left = 0;
        int right = citations.length;
        while (left <= right) {
            int mid = (right + left) / 2;

            int midPos = 0;
            int i = 0;
            for(; i < citations.length; i++) {
                if(citations[i] >= mid) {
                    midPos = i;
                    break;
                }
            }
            if(i >= citations.length) {
                right = mid - 1;
                continue;
            }

            int r = citations.length - midPos;

            if(mid <= r) {
                answer = Math.max(answer, mid);
            }

            if(mid <= r) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

}
