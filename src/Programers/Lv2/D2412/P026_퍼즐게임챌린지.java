package Programers.Lv2.D2412;

// https://school.programmers.co.kr/learn/courses/30/lessons/340212
public class P026_퍼즐게임챌린지 {
    private int[] diffs;
    private int[] times;
    private long limit;

    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;

        int start = 1;
        int end = 100000;

        while (start <= end) {
            int level = (end + start) / 2;
            if (canSolveInLimit(level)) end = level - 1;
            else start = level + 1;
        }
        return start;
    }


    private boolean canSolveInLimit(int level) {
        long spentTime = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level)
                spentTime += times[i];
            else
                spentTime += (long) (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
            if (spentTime > limit)
                return false; // 종료 조건
        }
        return true;
    }

}


