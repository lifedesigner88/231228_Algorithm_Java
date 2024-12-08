package Programers.Lv1.D2412;

// https://school.programmers.co.kr/learn/courses/30/lessons/12930
public class P022_이상한문자만들기 {
    public String solution1(String s) {
        StringBuilder sb = new StringBuilder();

        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            int target = s.charAt(i);
            if (Character.isLetter(target))
                sb.append(
                        counter++ % 2 == 0 ?
                                Character.toString(target).toUpperCase() :
                                Character.toString(target).toLowerCase()
                );
            else {
                sb.append(" ");
                counter = 0;
            }
        }

        return sb.toString();
    }

    public String solution2(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (Character.isLetter(target)) {
                if (counter % 2 == 0) {
                    sb.append(Character.toUpperCase(target));
                } else {
                    sb.append(Character.toLowerCase(target));
                }
                counter++;
            } else {
                sb.append(' ');
                counter = 0;
            }
        }

        return sb.toString();
    }
}
