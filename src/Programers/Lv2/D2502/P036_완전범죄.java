package Programers.Lv2.D2502;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/389480?language=java
public class P036_완전범죄 {

    // 예제 실행
    public static void main(String[] args) {
        P036_완전범죄 solver = new P036_완전범죄();
        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        int n = 4;
        int m = 4;
        System.out.println(solver.solution1(info, n, m)); // 최소 흔적 값 출력
        System.out.println(solver.solution2(info, n, m)); // 최소 흔적 값 출력
    }

    //  ✅ DP 방식.
    public int solution1(int[][] info, int n, int m) {
        int itemCount = info.length;
        int INF = 10000; // 충분히 큰 값 (실제 가능한 흔적 합보다 크도록 설정)

        // DP 배열 초기화 (A의 흔적 합을 최소화하는 값 저장)
        int[][] dp = new int[itemCount + 1][m];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0; // 시작점 (A와 B 모두 흔적이 0인 상태)

        // 각 물건에 대해 DP 테이블 갱신
        for (int i = 0; i < itemCount; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            int[][] nextDp = new int[itemCount + 1][m];
            for (int[] row : nextDp) {
                Arrays.fill(row, INF);
            }

            for (int j = 0; j < m; j++) { // 현재까지 B의 흔적
                if (dp[i][j] == INF) continue; // 유효하지 않은 상태는 건너뛰기

                // A가 훔치는 경우
                int nextATrace = dp[i][j] + aTrace;
                if (nextATrace < n) { // A의 흔적이 제한보다 작을 때만 갱신
                    nextDp[i + 1][j] = Math.min(nextDp[i + 1][j], nextATrace);
                }

                // B가 훔치는 경우
                int nextBTrace = j + bTrace;
                if (nextBTrace < m) { // B의 흔적이 제한보다 작을 때만 갱신
                    nextDp[i + 1][nextBTrace] = Math.min(nextDp[i + 1][nextBTrace], dp[i][j]);
                }
            }

            dp = nextDp; // 현재 테이블을 다음 단계로 업데이트
        }

        // 최솟값 찾기
        int result = INF;
        for (int j = 0; j < m; j++) {
            result = Math.min(result, dp[itemCount][j]);
        }

        return (result == INF) ? -1 : result;
    }

    static class State {
        int index, aTrace, bTrace;
        State(int index, int aTrace, int bTrace) {
            this.index = index;
            this.aTrace = aTrace;
            this.bTrace = bTrace;
        }
    }

    // ✅ BFS 방식
    public int solution2(int[][] info, int n, int m) {
        int itemCount = info.length;
        Queue<State> queue = new LinkedList<>();
        int[][] visited = new int[n][m]; // A와 B의 흔적 방문 체크
        for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);

        queue.add(new State(0, 0, 0));
        visited[0][0] = 0; // 초기 흔적 (0,0)

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.index == itemCount) {
                return current.aTrace;
            }

            int aNext = current.aTrace + info[current.index][0]; // A가 훔치는 경우
            int bNext = current.bTrace + info[current.index][1]; // B가 훔치는 경우

            if (aNext < n && current.bTrace < m && visited[aNext][current.bTrace] > aNext) {
                visited[aNext][current.bTrace] = aNext;
                queue.add(new State(current.index + 1, aNext, current.bTrace));
            }

            if (current.aTrace < n && bNext < m && visited[current.aTrace][bNext] > current.aTrace) {
                visited[current.aTrace][bNext] = current.aTrace;
                queue.add(new State(current.index + 1, current.aTrace, bNext));
            }
        }

        return -1; // 방법이 없는 경우
    }


}
