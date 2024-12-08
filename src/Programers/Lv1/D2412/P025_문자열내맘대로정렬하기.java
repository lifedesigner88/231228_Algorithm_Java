package Programers.Lv1.D2412;

import java.util.Arrays;
import java.util.Comparator;

// https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class P025_문자열내맘대로정렬하기 {

    public String[] solution1(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);
            if (c1 == c2)
                return o1.compareTo(o2);
            else
                return c1 - c2;
        });
        return strings;
    }

    public String[] solution2(String[] strings, int n) {
        Arrays.sort(strings,
                Comparator.comparing((String s) -> s.charAt(n))
                        .thenComparing(Comparator.naturalOrder()));
        return strings;

    }
}
