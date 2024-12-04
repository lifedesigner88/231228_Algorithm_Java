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

// set 으로 개선
class Solution009 {
    public int solution(String[] babbling) {
        String[] canBabb = { "aya", "ye", "woo", "ma" };
        int answer = 0;

        for (String b : babbling) {
            Set<String> set = new HashSet<>();

            while(!b.isEmpty()) {
                boolean match = false;
                for (String c : canBabb)
                    if (!set.contains(c) && b.startsWith(c)) {
                        b = b.substring(c.length());
                        set.clear();
                        set.add(c);
                        match = true;
                    }
                if (!match) break;
            }
            if (b.isEmpty()) answer++;

        }
        return answer;
    }
}