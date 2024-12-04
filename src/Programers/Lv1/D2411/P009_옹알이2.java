package Programers.Lv1.D2411;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/133499
public class P009_옹알이2 {

    public int solution(String[] babbling) {
        String[] canBabb = {"aya", "ye", "woo", "ma"};
        boolean[] flag = new boolean[4];
        int answer = 0;

        for (String b : babbling) {
            int counter = 0;
            Arrays.fill(flag, true);

            loop:
            while (counter++ < 20)
                for (int i = 0; i < 4; i++) {
                    if (flag[i] && b.startsWith(canBabb[i])) {
                        b = b.substring(canBabb[i].length());
                        Arrays.fill(flag, true);
                        if (b.isEmpty()) {
                            answer++;
                            break loop;
                        }
                        flag[i] = false;
                    }
                }
        }
        return answer;
    }
}


class Solution009 {
    public int solution(String[] babbling) {
        String[] canBabb = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (String b : babbling) {
            Set<String> recentPronunciations = new HashSet<>();
            boolean canPronounce = true;

            while (!b.isEmpty()) {
                boolean matched = false;

                for (String word : canBabb) {
                    if (b.startsWith(word) && !recentPronunciations.contains(word)) {
                        b = b.substring(word.length());
                        recentPronunciations.clear();
                        recentPronunciations.add(word);
                        matched = true;
                        break; // 매치되는 발음 찾으면, 루프 종료하고 다음 발음으로.
                    }
                }

                if (!matched) { // 매치되는 발음이 없으면 loop 중단
                    canPronounce = false;
                    break;
                }
            }

            if (canPronounce) {
                answer++;
            }
        }

        return answer;
    }
}