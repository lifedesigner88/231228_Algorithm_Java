package Programers.Lv2.D2412;

// https://school.programmers.co.kr/learn/courses/30/lessons/250135
public class P030_아날로그시계 {

    //    ✅ 세종 풀이
    private double periodHourS, periodMinuteS;

    public int solution1(int h1, int m1, int s1, int h2, int m2, int s2) {

        int startTime = getSecond(h1, m1, s1); // 초로 변환
        int endTime = getSecond(h2, m2, s2);

        double hourSpeed = 360.0 / (60 * 60 * 12); // 초속
        double minuteSpeed = 360.0 / (60 * 60); // 초속
        double secondSpeed = 360.0 / 60; // 초속

        double relHourSecond = secondSpeed - hourSpeed;     // 시침 초침 상대속도
        double relMinuteSecond = secondSpeed - minuteSpeed; // 분침 초침 상대속도

        this.periodHourS = 360 / relHourSecond;     // 시침과 초침이 한 번 만나는데 필요한 (초)
        this.periodMinuteS = 360 / relMinuteSecond; // 분침과 초침이 한 번 만나는데 필요한 (초)

        int howManyToStart = howManyEncount(startTime); // 00시 부터 시작시간 까지 몇번 겹치는지 카운트
        int howManyToEnd = howManyEncount(endTime); // 00시 부터 종료 시간까지 겹치는 카운트

        int threeHMS = (startTime < (60 * 60 * 12) && endTime >= (60 * 60 * 12)) ? 1 : 0;  // 시간이 12:00:00 를 지나거나 딱 종료되면 1을 뺴줘야 한다.
        int startRing = (startTime == 0 || startTime == (60 * 60 * 12)) ? 1 : 0; // 시작시간이 0시 또는 12시 일때 시작하자마자 1번 울린다.

        return howManyToEnd - howManyToStart - threeHMS + startRing; //
    }

    private int getSecond(int h, int m, int s) {
        return 3600 * h + 60 * m + s;
    }

    private int howManyEncount(int second) {
        int howManyHS = (int) (second / periodHourS);
        int howManyMS = (int) (second / periodMinuteS);
        return howManyMS + howManyHS;
    }

//    ✅ GPT 정리

    // 상수 계산 (초속)
    private static final double HOUR_HAND_SPEED = 360.0 / (60 * 60 * 12);
    private static final double MINUTE_HAND_SPEED = 360.0 / (60 * 60);
    private static final double SECOND_HAND_SPEED = 360.0 / 60;

    // 상대 속도
    private static final double RELATIVE_HOUR_SECOND = SECOND_HAND_SPEED - HOUR_HAND_SPEED;
    private static final double RELATIVE_MINUTE_SECOND = SECOND_HAND_SPEED - MINUTE_HAND_SPEED;

    // 주기 (초 단위로 계산된 주기)
    private static final double PERIOD_HOUR_SECOND = 360.0 / RELATIVE_HOUR_SECOND;
    private static final double PERIOD_MINUTE_SECOND = 360.0 / RELATIVE_MINUTE_SECOND;

    public int solution2(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 시작 시간과 종료 시간을 초 단위로 변환
        int startTime = convertToSeconds(h1, m1, s1);
        int endTime = convertToSeconds(h2, m2, s2);

        // 00시부터 몇 번 겹칭했는지 계산
        int overlapStart = calculateOverlapCount(startTime);
        int overlapEnd = calculateOverlapCount(endTime);

        // 12:00:00을 지나는지 여부 확인
        boolean crossesNoon = startTime < (12 * 60 * 60) && endTime >= (12 * 60 * 60);
        // 시작점이 0시(또는 12시)인지 확인
        boolean startsOnExactHour = (startTime == 0 || startTime == (12 * 60 * 60));

        // 최종 결과 계산
        return overlapEnd - overlapStart - (crossesNoon ? 1 : 0) + (startsOnExactHour ? 1 : 0);
    }

    private int convertToSeconds(int hours, int minutes, int seconds) {
        return hours * 3600 + minutes * 60 + seconds;
    }

    private int calculateOverlapCount(int seconds) {
        // 시침-초침, 분침-초침의 겹침 횟수 계산
        int hourOverlaps = (int) (seconds / PERIOD_HOUR_SECOND);
        int minuteOverlaps = (int) (seconds / PERIOD_MINUTE_SECOND);
        return hourOverlaps + minuteOverlaps;
    }

}
