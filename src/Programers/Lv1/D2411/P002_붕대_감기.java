package Programers.Lv1.D2411;

// https://school.programmers.co.kr/learn/courses/30/lessons/250137
public class P002_붕대_감기 {


    public static int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량

        int maxHealth = health;
        int sequence = 0;
        int currentTime = 0;
        int attackIndex = 0; // 공격의 인덱스
        int lastAttack = attacks[attacks.length - 1][0];

        while (currentTime <= lastAttack) {
            // 현재 시간이 공격 시간과 일치하면 공격 처리
            if (attackIndex < attacks.length && currentTime == attacks[attackIndex][0]) {
                health -= attacks[attackIndex][1];

                if (health <= 0) return -1; // 체력이 0 이하이면 사망

                attackIndex++;
                sequence = 0; // 공격을 받았으니 시퀀스 초기화
            } else {
                // 공격을 받지 않으면 회복 시도
                sequence++;
                health = Math.min(health + x, maxHealth);

                // 연속 시도 시간이 완료되면 추가 회복 처리
                if (sequence == t) {
                    health = Math.min(health + y, maxHealth);
                    sequence = 0; // 시퀀스 초기화
                }
            }
            currentTime++;
        }
        return health;
    }

    public static void main(String[] args) {
        int[] bandage = {5, 1, 5}; // 붕대 감기 시전 시간, 1초당 회복량, 추가 회복량
        int health = 30; // 최대 체력
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}}; // 공격 시간과 피해량

        int result = solution(bandage, health, attacks);
        System.out.println("남은 체력: " + result);
    }
}
