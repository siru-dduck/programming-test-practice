package kakao;

/**
 * 2021 KAKAO BLIND RECRUITMENT - 신규 아이디 추천
 *
 * @link{https://programmers.co.kr/learn/courses/30/lessons/72410}
 */
public class NewIdRecommend {

    private StringBuffer removeDotAtBothEnds(StringBuffer buffer) {
        if (buffer.length() > 0 && buffer.charAt(0) == '.') {
            buffer.deleteCharAt(0);
        }
        if (buffer.length() > 0 && buffer.charAt(buffer.length() - 1) == '.') {
            buffer.deleteCharAt(buffer.length() - 1);
        }
        return buffer;
    }

    public String solution(String new_id) {
        /**
         * 1단계
         * 소문자 치환
         */
        String answer = "";
        StringBuffer buffer = new StringBuffer(new_id.toLowerCase());
        System.out.println("1단계: " + buffer.toString());

        /**
         * 2단계 숫자, 알파벳 및 '-', '_', '.' 제외한 문자 제거
         */
        for (int i = 0; i < buffer.length(); ) {
            char ch = buffer.charAt(i);
            if (('0' <= ch && ch <= '9') || ('a' <= ch && ch <= 'z') || ch == '-' || ch == '_' || ch == '.') {
                i++;
                continue;
            }
            buffer.deleteCharAt(i);
        }
        System.out.println("2단계: " + buffer.toString());

        /**
         * 3 단계 . 2번이상 .으로 대체
         */
        int continuousDotNum = 0;
        for (int i = 0; i < buffer.length(); ) {
            if (buffer.charAt(i) == '.') {
                continuousDotNum++;
                if (continuousDotNum >= 2) {
                    buffer.deleteCharAt(i);
                } else {
                    i++;
                }
            } else {
                continuousDotNum = 0;
                i++;
            }
        }
        System.out.println("3단계: " + buffer.toString());

        /**
         * 4단계
         * 마침표(.)가 처음이나 끝에 위치한다면 제거
         */
        buffer = removeDotAtBothEnds(buffer);
        System.out.println("4단계: " + buffer.toString());

        /**
         * 5 단계
         * 빈 문자열이라면, new_id에 "a"를 대입합니다.
         */
        if (buffer.length() < 1) {
            buffer.append('a');
        }
        System.out.println("5단계: " + buffer.toString());

        /**
         * 6단계
         * new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
         * 만약 제거 후 마침표(.)가 문자열의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
         */
        if (buffer.length() >= 16) {
            buffer = new StringBuffer(buffer.substring(0, 15));
            buffer = removeDotAtBothEnds(buffer);
        }
        System.out.println("6단계: " + buffer.toString());

        /**
         * 7단계
         * 길이가 2자 이하라면, 문자열의 마지막 문자를 문자열의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
         */
        if (buffer.length() <= 2) {
            if(buffer.length() == 1) {
                buffer.append(buffer.charAt(0));
                buffer.append(buffer.charAt(0));
            } else if(buffer.length() == 2) {
                buffer.append(buffer.charAt(1));
            } else {
                throw new IllegalStateException();
            }
        }
        System.out.println("7단계: " + buffer.toString());
        answer = buffer.toString();
        return answer;
    }
}
