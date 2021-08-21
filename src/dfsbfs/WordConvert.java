package dfsbfs;

import java.util.*;

public class WordConvert {

    /**
     * 문자열이 글자 하나만 다른지 체크하는 함수
     *
     * @param target1
     * @param target2
     * @return
     */
    boolean isHit(String target1, String target2) {
        if (target1.length() != target2.length()) {
            return false;
        }
        int differentCount = 0;
        for (int i = 0; i < target1.length(); i++) {
            if (target1.charAt(i) != target2.charAt(i)) {
                differentCount++;
            }

            if (differentCount >= 2) {
                break;
            }
        }

        if (differentCount == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * dfs
     * @param begin
     * @param target
     * @param words
     * @param visit
     * @param step
     */
    public int dfs(String begin, String target, String[] words, Set<String> visit, int step) {
        step++;
        if(begin.equals(target)) {
            return step;
        }

        int min = 0;
        for(String word : words) {
            if(!visit.contains(word) && isHit(begin, word)) {
                Set<String> newVisit = new HashSet<>(visit);
                newVisit.add(word);
                int temp = dfs(word, target, words, newVisit, step);
                if(min == 0 || temp < min) {
                    min = temp;
                }
            }
        }
        return min;
    }


    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        List<String> queue = new ArrayList<>();

        /* target단어가 있는지 검색 */
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        /* 문자열 dfs 검색 */
        answer = dfs(begin, target, words, new HashSet<>(), -1);

        return answer;
    }

}
