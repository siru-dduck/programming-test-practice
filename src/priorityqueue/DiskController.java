package priorityqueue;

import java.util.*;

public class DiskController {

    public static int solution(int[][] jobs) {
        List<int[]> jobList = new LinkedList<>(Arrays.asList(jobs));
        int answer = 0;
        int current_time = 0;

        jobList.sort((arg0, arg1) -> {
            if (arg0[0] == arg1[0]) {
                if (arg0[1] == arg1[1]) {
                    return 0;
                } else if (arg0[1] < arg1[1]) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (arg0[0] < arg1[0]) {
                return -1;
            } else {
                return 1;
            }
        });

        while (jobList.size() != 0) {
            int min_job_index = 0;
            if (jobList.get(0)[0] > current_time) {
                current_time++;
                continue;
            }
            for (int i = 1; i < jobList.size(); i++) {
                if (jobList.get(i)[0] > current_time) {
                    break;
                }
                if (jobList.get(i)[1] < jobList.get(min_job_index)[1]) {
                    min_job_index = i;
                }
            }
            answer += (current_time + jobList.get(min_job_index)[1]) - jobList.get(min_job_index)[0];
            current_time = current_time + jobList.get(min_job_index)[1];
            jobList.remove(min_job_index);
        }
        return answer / jobs.length;
    }

    public static void main(String[] args) {
        System.out.println("츨력:");
        System.out.println(solution(new int[][]{{0,3}, {1,9}, {2,6}}));
    }
}
