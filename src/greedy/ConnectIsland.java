package greedy;

import java.util.Arrays;

class ConnectIsland {

    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (arr1, arr2) -> Integer.compare(arr1[2], arr2[2]));
        int[] union = new int[n];

        for(int i = 0; i < n; i++) {
            union[i] = i;
        }

        for (int[] cost : costs) {
            if(union[cost[0]] != union[cost[1]]) {
                int one = union[cost[0]];
                int other = union[cost[1]];
                for(int i = 0; i < n; i++) {
                    if(union[i] == other) {
                        union[i] = one;
                    }
                }
                answer += cost[2];
            }
        }

        return answer;
    }
}