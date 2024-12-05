package Programers.Lv1.D2412;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class P012_성격유형검사하기 {

    public String solution1(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Character[][] result = {
                {'R','T'},
                {'C','F'},
                {'J','M'},
                {'A','N'}
        };

        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int score = choices[i] - 4;
            if (score < 0)
                map.put(first, map.getOrDefault(first, 0) + (-1) * score);
            else
                map.put(second, map.getOrDefault(second, 0) + score );
        }

        for (int i = 0; i < 4; i++) {
            Character a = result[i][0];
            Character b = result[i][1];
            int score1 = map.getOrDefault(a, 0);
            int score2 = map.getOrDefault(b, 0);
            sb.append(score1 >= score2 ? a : b);
        }

        return sb.toString();
    }

    public String solution2(String[] survey, int[] choices) {
        char[][] result = {
                {'R','T'},
                {'C','F'},
                {'J','M'},
                {'A','N'}
        };

        // int 배열을 사용하여 점수를 계산합니다. HashMap보다 빠릅니다.
        int[] scores = new int[26]; // 알파벳 개수만큼

        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int score = choices[i] - 4;

            // 조건문을 하나로 줄입니다.
            scores[score < 0 ? first - 'A' : second - 'A'] += Math.abs(score); // 절대값.
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char a = result[i][0];
            char b = result[i][1];
            // scores 배열에서 바로 점수를 가져옵니다.
            sb.append(scores[a - 'A'] >= scores[b - 'A'] ? a : b);
        }

        return sb.toString();
    }

}
