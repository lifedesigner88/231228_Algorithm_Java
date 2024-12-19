package Programers.Lv2.D2412;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/172927
public class P034_광물캐기 {

    private String[] minerals;
    private final PriorityQueue<int[]> rocksQue = new PriorityQueue<>(  // 작업을 5개 단위로 쪼개서 정렬
            Comparator.comparingInt((int[] i) -> i[0])
                    .thenComparing(i -> i[1])
                    .reversed()
    );
    private final int[][] tired = {
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1},
    };

    public int solution(int[] picks, String[] minerals) {
        this.minerals = minerals;

        int pickSize = Arrays.stream(picks).sum();
        int canMineSize = Math.min(pickSize * 5, minerals.length);

        // 5개 단위로 작업 영역에 넣기 (난이도별)
        for (int i = 0; i < canMineSize; i += 5) cutWorks(i);

        int answer = 0;
        for (int i = 0; i < 3; i++) // 도구 종류
            for (int j = 0; j < picks[i]; j++) // 도구 갯수
                answer += getTired(i); // 위 도구로 단위 업무 처리

        return answer;
    }

    private int getTired(int toolIdx) {
        int tiredSum = 0;
        if (!rocksQue.isEmpty()) {  // 작업이 남아있다면
            int[] work = rocksQue.poll();
            for (int i = 0; i < 3; i++) // 광물 종류
                for (int j = 0; j < work[i]; j++)
                    tiredSum += tired[toolIdx][i];
        }
        return tiredSum;
    }

    private void cutWorks(int startIdx) {   // 5개씩 조사해서 카운트
        int endIdx = Math.min(startIdx + 5, minerals.length); // 5개 단위로 끊음.
        int[] search = new int[3];
        for (int i = startIdx; i < endIdx; i++) // 5개 조사
            switch (minerals[i]) {
                case "diamond":
                    search[0]++;
                    break;
                case "iron":
                    search[1]++;
                    break;
                case "stone":
                    search[2]++;
                    break;
            }
        rocksQue.offer(search); // 우선순위 큐에 삽입.
    }



    // AI 정렬
    public int solution2(int[] picks, String[] minerals) {
        int totalPicks = Arrays.stream(picks).sum(); // 총 곡괭이 수
        int maxMineable = Math.min(totalPicks * 5, minerals.length); // 캐낼 최대 광물 수

        // 5개 단위로 작업 영역에 넣기 (우선순위큐)
        for (int i = 0; i < maxMineable; i += 5) groupWorks(minerals, i, Math.min(i + 5, maxMineable));

        int fatigue = 0;
        for (int tool = 0; tool < 3; tool++) { // 곡괭이 종류 순회
            for (int count = 0; count < picks[tool]; count++) { // 해당 곡괭이 수만큼 사용
                if (rocksQue.isEmpty()) break; // 더 이상 작업이 없으면 종료
                fatigue += calculateFatigue(tool, rocksQue.poll());
            }
        }

        return fatigue;
    }

    // 피로도를 계산
    private int calculateFatigue(int toolIdx, int[] work) {
        int fatigue = 0;
        for (int i = 0; i < 3; i++) { // 광물 종류마다 피로도 계산
            fatigue += work[i] * tired[toolIdx][i];
        }
        return fatigue;
    }

    // 5개 단위로 광물 카운트
    private void groupWorks(String[] minerals, int start, int end) {
        int[] count = new int[3]; // {diamond, iron, stone} 카운트
        for (int i = start; i < end; i++) {
            switch (minerals[i]) {
                case "diamond" -> count[0]++;
                case "iron" -> count[1]++;
                case "stone" -> count[2]++;
            }
        }
        rocksQue.offer(count); // 우선순위 큐에 추가
    }




    // DFS 풀이
    private int minFatigue = Integer.MAX_VALUE; // 최소 피로도 저장

    public int solution3(int[] picks, String[] minerals) {
        int totalPicks = Arrays.stream(picks).sum(); // 총 곡괭이 개수
        int maxMineable = Math.min(totalPicks * 5, minerals.length); // 캘 수 있는 최대 광물 수

        // DFS 탐색 시작
        dfs(picks, minerals, 0, maxMineable, 0);
        return minFatigue;
    }

    private void dfs(int[] picks, String[] minerals, int index, int maxMineable, int currentFatigue) {
        // 종료 조건: 모든 광물을 캤거나, 곡괭이를 다 쓴 경우
        if (index >= maxMineable || (picks[0] + picks[1] + picks[2] == 0)) {
            minFatigue = Math.min(minFatigue, currentFatigue); // 최소 피로도 갱신
            return;
        }

        // 곡괭이 종류별로 선택하면서 탐색
        for (int tool = 0; tool < 3; tool++) {
            if (picks[tool] > 0) { // 남은 곡괭이가 있을 때만 선택
                picks[tool]--; // 곡괭이 사용

                // 현재 곡괭이로 5개의 광물을 캘 때 피로도 계산
                int fatigue = 0;
                for (int i = index; i < Math.min(index + 5, maxMineable); i++) {
                    switch (minerals[i]) {
                        case "diamond":
                            fatigue += tired[tool][0];
                            break;
                        case "iron":
                            fatigue += tired[tool][1];
                            break;
                        case "stone":
                            fatigue += tired[tool][2];
                            break;
                    }
                }

                // 다음 상태로 dfs 탐색
                dfs(picks, minerals, index + 5, maxMineable, currentFatigue + fatigue);

                // 백트래킹: 곡괭이 복구
                picks[tool]++;
            }
        }
    }

}
