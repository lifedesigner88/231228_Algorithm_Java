package Programers.Lv1.D2412;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/77484
public class P014_로또최고순위와최저순위 {
    public int[] solution1(int[] lottos, int[] win_nums) {
        int[] lot = new int[46];
        int count = 0;

        for (int a : lottos) lot[a]++;
        for (int b : win_nums)
            if (lot[b] == 1) count++;

        return new int[]{cal(count + lot[0]), cal(count)};
    }

    // 일치한 개수로 등수 계산
    private int cal(int count) {
        return Math.min((-1 * count) + 7, 6);
    }

    // 1000개 이하일땐 Set이더 느림.
    public int[] solution2(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();
        int zeroCount = 0;
        int matchCount = 0;

        for (int winNum : win_nums) {
            winSet.add(winNum);
        }

        for (int lottoNum : lottos) {
            if (lottoNum == 0) {
                zeroCount++;
            } else if (winSet.contains(lottoNum)) {
                matchCount++;
            }
        }

        return new int[]{rank(matchCount + zeroCount), rank(matchCount)};
    }

    private int rank(int matchCount) {
        return Math.min(7 - matchCount, 6);
    }
}
