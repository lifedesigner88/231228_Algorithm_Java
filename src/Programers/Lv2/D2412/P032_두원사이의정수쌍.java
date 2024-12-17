package Programers.Lv2.D2412;

// https://school.programmers.co.kr/learn/courses/30/lessons/181187
public class P032_두원사이의정수쌍 {

    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 0; x < r1; x++) {
            double big = getRawY(x, r2);
            double small = getRawY(x, r1);

            int bigF = (int) Math.floor(big);
            int smallC = (int) Math.ceil(small);

            if (smallC <= bigF) // 불필요함.
                answer += bigF - smallC + 1;
        }

        for (int x = r1; x < r2; x++) {
            double big = getRawY(x, r2);
            answer += (long) Math.floor(big);
        }

        return answer * 4;
    }

    private double getRawY(int x, int rad) {
        return Math.sqrt((long) rad * rad - (long) x * x);
    }

}
