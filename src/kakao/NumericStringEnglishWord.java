package kakao;

public class NumericStringEnglishWord {

    public int solution(String s) {
        int answer = 0;
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i < s.length();) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                buffer.append(s.charAt(i));
                i++;
                continue;
            }

            if(s.startsWith("zero", i)) {
                buffer.append('0');
                i += "zero".length();
            } else if(s.startsWith("one", i)) {
                buffer.append('1');
                i += "one".length();
            } else if(s.startsWith("two", i)) {
                buffer.append('2');
                i += "two".length();
            } else if(s.startsWith("three", i)) {
                buffer.append('3');
                i += "three".length();
            } else if(s.startsWith("four", i)) {
                buffer.append('4');
                i += "four".length();
            } else if(s.startsWith("five", i)) {
                buffer.append('5');
                i += "five".length();
            } else if(s.startsWith("six", i)) {
                buffer.append('6');
                i += "six".length();
            } else if(s.startsWith("seven", i)) {
                buffer.append('7');
                i += "seven".length();
            } else if(s.startsWith("eight", i)) {
                buffer.append('8');
                i += "eight".length();
            } else if(s.startsWith("nine", i)) {
                buffer.append('9');
                i += "nine".length();
            } else {
                throw new IllegalStateException();
            }
        }
        return Integer.parseInt(buffer.toString());
    }

}
