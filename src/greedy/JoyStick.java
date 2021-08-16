package greedy;

public class JoyStick {

    public int solution(String name) {
        int upDownCount = 0;
        int leftRightCount = 0;

        /**
         * 상하로 움직이는 경우의 수 구하기
         */
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) <= (('A' + 'Z') / 2)) {
                upDownCount += (name.charAt(i) - 'A');
            } else {
                 upDownCount += (('Z' + 1) - name.charAt(i));
            }
        }

        /**
         * 좌우로 움직이는 경우의 수 구하기
         */

        /* 왼쪽에 존재하는 A집합 - 맨 처음이 'A'인 케이스는 제외 */
        int leftASetStartAt = -1;
        int leftASetLength = 0;
        for(int i = 1; i < name.length(); i++) {
            if(leftASetStartAt == -1) {
                if(name.charAt(i) == 'A') {
                    leftASetStartAt = i;
                    leftASetLength++;
                }
            } else {
                if(name.charAt(i) == 'A') {
                    leftASetLength++;
                } else {
                    break;
                }
            }

        }

        int rightASetStartAt = -1;
        int rightASetLength = 0;
        for(int i = name.length()-1; i >= 0; i--) {
            if(rightASetStartAt == -1) {
                if(name.charAt(i) == 'A') {
                    rightASetStartAt = i;
                    rightASetLength++;
                }
            } else {
                if(name.charAt(i) == 'A') {
                    rightASetLength++;
                } else {
                    break;
                }
            }

        }

        // 1. 오른쪽으로만 쭉 이동 또는 왼쪽으로만 쭉 이동
        int case1 = name.length() -1;
        leftRightCount = case1;
        if(leftASetStartAt != -1) {
            // 2. 오른쪽으로 갔다 왼쪽으로 이동
            int case2 = (leftASetStartAt -1) * 2 + (name.length() - (leftASetStartAt + leftASetLength));
            leftRightCount = Math.min(case2, leftRightCount);
            // 3. 왼쪽으로 갔다 오른쪽으로 이동
            int case3 = (name.length() - rightASetStartAt -1) * 2 + (rightASetStartAt - rightASetLength);

            leftRightCount = Math.min(case3, leftRightCount);

        }

        return upDownCount + leftRightCount;
    }

}