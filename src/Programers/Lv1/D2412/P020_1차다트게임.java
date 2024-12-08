package Programers.Lv1.D2412;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/17682
public class P020_1차다트게임 {

    public int solution1(String dartResult) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;

        for (int i = 0; i < dartResult.length(); i++) {
            char target = dartResult.charAt(i);
            if ('0' <= target && target <= '9') // 숫자의 경우
                if (target == '1') {
                    char nextTarget = dartResult.charAt(i + 1);
                    if (nextTarget == '0') {
                        map.put(count++, 10);
                        i++;
                    } else
                        map.put(count++, 1);
                } else
                    map.put(count++, Character.getNumericValue(target));
            else { // 문자의 경우
                int targetNum = count - 1;
                switch (target) {
                    case 'D':
                        map.computeIfPresent(targetNum, (k, v) -> v * v);
                        break;

                    case 'T':
                        map.compute(targetNum, (k, v) -> v * v * v);
                        break;

                    case '*':
                        map.compute(targetNum, (k, v) -> v * 2);
                        if (targetNum != 1)
                            map.compute(targetNum - 1, (k, v) -> v * 2);
                        break;

                    case '#':
                        map.compute(targetNum, (k, v) -> v * -1);
                        break;
                }
            }
        }

        return map.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }


    // 배열을 통한 풀이, 최적화. 게임이 3번만 진행되니 배열이 좋음.
    public int solution2(String dartResult) {
        int[] scores = new int[3];
        int count = 0;
        int n = dartResult.length();

        for (int i = 0; i < n; i++) {
            char target = dartResult.charAt(i);
            if (Character.isDigit(target)) {
                int num;
                if (target == '1' && i + 1 < n && dartResult.charAt(i + 1) == '0') {
                    num = 10;
                    i++; // 다음 '0' 문자를 건너뜁니다.
                } else {
                    num = Character.getNumericValue(target);
                }
                scores[count++] = num;
            } else {
                int targetIndex = count - 1;
                switch (target) {
                    case 'S':
                        scores[targetIndex] = (int)Math.pow(scores[targetIndex], 1);
                        break;
                    case 'D':
                        scores[targetIndex] = (int)Math.pow(scores[targetIndex], 2);
                        break;
                    case 'T':
                        scores[targetIndex] = (int)Math.pow(scores[targetIndex], 3);
                        break;
                    case '*':
                        if (targetIndex > 0) {
                            scores[targetIndex - 1] *= 2;
                        }
                        scores[targetIndex] *= 2;
                        break;
                    case '#':
                        scores[targetIndex] *= -1;
                        break;
                }
            }
        }

        return Arrays.stream(scores).sum();
    }
}
