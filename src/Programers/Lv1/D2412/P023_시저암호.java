package Programers.Lv1.D2412;


// https://school.programmers.co.kr/learn/courses/30/lessons/12926
public class P023_시저암호 {
    public String solution1(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            int push = (target + n);

            if (Character.isUpperCase(target))
                sb.append(push > 'Z' ? (char) ('A' + (push % 'Z') - 1) : (char) push);
            else if (Character.isLowerCase(target))
                sb.append(push > 'z' ? (char) ('a' + (push % 'z') - 1) : (char) push);
            else
                sb.append(" ");
        }

        return sb.toString();
    }


    public String solution2(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (char target : s.toCharArray()) {
            if (Character.isUpperCase(target)) {
                char shifted = (char) ((target - 'A' + n) % 26 + 'A');
                sb.append(shifted);
            } else if (Character.isLowerCase(target)) {
                char shifted = (char) ((target - 'a' + n) % 26 + 'a');
                sb.append(shifted);
            } else {
                sb.append(target); // 공백이나 다른 문자는 그대로 추가
            }
        }

        return sb.toString();
    }
}
