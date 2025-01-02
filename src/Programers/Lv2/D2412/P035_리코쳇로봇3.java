package Programers.Lv2.D2412;


import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/169199
public class P035_리코쳇로봇3 {

    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();

        // 시작(R)과 목표점(G)의 좌표를 확인
        int startX = -1, startY = -1, goalX = -1, goalY = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char cell = board[i].charAt(j);
                if (cell == 'R') {
                    startX = i;
                    startY = j;
                } else if (cell == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        // BFS 초기화
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});  // [x, y, 이동 횟수]
        boolean[][] visited = new boolean[rows][cols];
        visited[startX][startY] = true;

        // 이동 방향 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            // 목표 지점(G)에 도달했는지 확인
            if (x == goalX && y == goalY) {
                return moves;
            }

            // 상, 하, 좌, 우로 이동
            for (int dir = 0; dir < 4; dir++) {
                int nx = x;
                int ny = y;

                // 해당 방향으로 미끄러짐
                while (nx + dx[dir] >= 0 && nx + dx[dir] < rows &&
                        ny + dy[dir] >= 0 && ny + dy[dir] < cols &&
                        board[nx + dx[dir]].charAt(ny + dy[dir]) != 'D') {
                    nx += dx[dir];
                    ny += dy[dir];
                }

                // 새로운 위치를 방문하지 않았다면 이동
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, moves + 1});
                }
            }
        }

        // 목표 지점에 도달하지 못한 경우
        return -1;
    }
}
