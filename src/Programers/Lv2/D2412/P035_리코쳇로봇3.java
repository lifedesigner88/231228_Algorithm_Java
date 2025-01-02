package Programers.Lv2.D2412;


import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/169199
public class P035_리코쳇로봇3 {

        private String[] board;
        private Map<Integer, TreeSet<Integer>> Xmap = new HashMap<>();
        private Map<Integer, TreeSet<Integer>> Ymap = new HashMap<>();
        private int[] R, G;
        private int height, width;

        public int solution(String[] board) {
            this.board = board;
            this.height = board.length;
            this.width = board[0].length();

            // 지도 초기화
            initializeMaps();

            // BFS 실행
            return bfs();
        }

        private void initializeMaps() {
            for (int x = 0; x < height; x++) {
                Xmap.put(x, new TreeSet<>()); // 행 장애물 초기화
            }
            for (int y = 0; y < width; y++) {
                Ymap.put(y, new TreeSet<>()); // 열 장애물 초기화
            }

            // 장애물 위치와 시작/목표 좌표 초기화
            for (int x = 0; x < height; x++) {
                for (int y = 0; y < width; y++) {
                    char cell = board[x].charAt(y);
                    switch (cell) {
                        case 'D': {
                            Xmap.get(x).add(y);
                            Ymap.get(y).add(x);
                            break;
                        }
                        case 'R': {
                            R = new int[] {x, y};
                            break;
                        }
                        case 'G': {
                            G = new int[] {x, y};
                            break;
                        }
                    }
                }
            }
        }

        private int bfs() {
            // BFS 초기화
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[height][width];

            queue.add(new int[] {R[0], R[1], 0}); // (x, y, 이동 횟수)
            visited[R[0]][R[1]] = true;

            // BFS 탐색
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0], y = current[1], moves = current[2];

                // 목표 지점에 도달 시 이동 횟수 반환
                if (x == G[0] && y == G[1]) return moves;

                // 4방향 탐색
                for (int[] direction : new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                    int[] next = slideUntilObstacle(x, y, direction);
                    if (!visited[next[0]][next[1]]) {
                        visited[next[0]][next[1]] = true;
                        queue.add(new int[] {next[0], next[1], moves + 1});
                    }
                }
            }

            // 목표 지점에 도달할 수 없을 경우
            return -1;
        }

        private int[] slideUntilObstacle(int x, int y, int[] direction) {
            int dx = direction[0];
            int dy = direction[1];

            if (dx != 0) {
                // 수직 이동
                TreeSet<Integer> set = Ymap.get(y);
                Integer next = (dx == -1) ? set.lower(x) : set.higher(x);
                x = (next == null) ? (dx == -1 ? 0 : height - 1) : (dx == -1 ? next + 1 : next - 1);
            } else if (dy != 0) {
                // 수평 이동
                TreeSet<Integer> set = Xmap.get(x);
                Integer next = (dy == -1) ? set.lower(y) : set.higher(y);
                y = (next == null) ? (dy == -1 ? 0 : width - 1) : (dy == -1 ? next + 1 : next - 1);
            }

            return new int[] {x, y};
        }
}
