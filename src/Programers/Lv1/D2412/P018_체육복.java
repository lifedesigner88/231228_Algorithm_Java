package Programers.Lv1.D2412;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class P018_체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] health = new int[n + 2];
        Arrays.fill(health, 1);

        for (int r : reserve) health[r]++;
        for (int l : lost) health[l]--;

        int[] health2 = health.clone(); // 배열 복제.

        for (int l : lost) {
            if (health[l] == 0) // 뒷 사람 부터 조사
                if (health[l + 1] == 2) {
                    health[l]++;
                    health[l + 1]--;
                } else if (health[l - 1] == 2) {
                    health[l]++;
                    health[l - 1]--;
                }

            if (health2[l] == 0) // 앞 사람 부터 조사
                if (health2[l - 1] == 2) {
                    health2[l]++;
                    health2[l - 1]--;
                } else if (health2[l + 1] == 2) {
                    health2[l]++;
                    health2[l + 1]--;
                }
        }

        int answer1 = 0;
        int answer2 = 0;
        for (int i = 1; i <= n; i++) {
            if (health[i] >= 1) answer1++;
            if (health2[i] >= 1) answer2++;
        }

        return Math.max(answer1, answer2);
    }
}
