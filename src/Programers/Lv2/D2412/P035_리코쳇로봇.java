package Programers.Lv2.D2412;


import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/169199
public class P035_리코쳇로봇 {

    private String[] board;
    private final Map<Integer, TreeSet<Integer>> Xmap = new HashMap<>();
    private final Map<Integer, TreeSet<Integer>> Ymap = new HashMap<>();
    private int[] R, G;
    private int height, width;

    public int solution(String[] board) {
        this.board = board;
        this.height = board.length;
        this.width = board[0].length();

        for (int x = 0; x < height; x++)
            for (int y = 0; y < width; y++)
                switch (get(x, y)) {
                    case 'D' -> {
                        Xmap.computeIfAbsent(x, key -> new TreeSet<>()).add(y);
                        Ymap.computeIfAbsent(y, key -> new TreeSet<>()).add(x);
                    }
                    case 'R' -> R = new int[]{x, y};
                    case 'G' -> G = new int[]{x, y};
                }

        return bfs();
    }

    private char get(int x, int y) {
        return board[x].charAt(y);
    }

    private int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];

        // BFS 시작 위치
        queue.add(new int[]{R[0], R[1], 0}); // x, y, 이동 횟수
        visited[R[0]][R[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            // 목표 지점에 도달하면 이동 횟수 반환
            if (x == G[0] && y == G[1]) {
                return moves;
            }

            // 상하좌우 방향으로 이동
            for (int[] next : new int[][]{
                    checkUp(current),
                    checkRight(current),
                    checkDown(current),
                    checkLeft(current)}) {
                if (next != null && !visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new int[]{next[0], next[1], moves + 1});
                }
            }
        }

        // 목표에 도달하지 못한 경우
        return -1;
    }


    //  🤷‍♂️🤷‍♂️🤷‍♂️
    private int[] checkUp(int[] target) {
        Integer tempX;
        TreeSet<Integer> set = Ymap.get(target[1]);
        if (set == null) return new int[]{0, target[1]};
        tempX = set.lower(target[0]);
        if (tempX == null) return new int[]{0, target[1]};
        if (target[0] - tempX == 1) return null;
        return new int[]{tempX + 1, target[1]};
    }

    //간단한 로직.
    private int[] checkUp(int x, int y) {
        Integer nextX = Ymap.getOrDefault(y, new TreeSet<>()).lower(x); // 위쪽 위치 계산
        return new int[]{nextX == null ? 0 : nextX + 1, y};
    }

    private int[] checkRight(int[] target) {
        Integer tempY;
        TreeSet<Integer> set = Xmap.get(target[0]);
        if (set == null) return new int[]{target[0], width - 1};
        tempY = set.higher(target[1]);
        if (tempY == null) return new int[]{target[0], width - 1};
        if (tempY - target[1] == 1) return null;
        return new int[]{target[0], tempY - 1};
    }

    private int[] checkDown(int[] target) {
        Integer tempX;
        TreeSet<Integer> set = Ymap.get(target[1]);
        if (set == null) return new int[]{height - 1, target[1]};
        tempX = set.higher(target[0]);
        if (tempX == null) // 장애물 없으면 경계값 리턴
            return new int[]{height - 1, target[1]};
        if (tempX - target[0] == 1) return null;
        return new int[]{tempX - 1, target[1]};
    }

    private int[] checkLeft(int[] target) {
        Integer tempY;
        TreeSet<Integer> set = Xmap.get(target[0]);
        if (set == null) return new int[]{target[0], 0};
        tempY = set.lower(target[1]);
        if (tempY == null) return new int[]{target[0], 0};
        if (target[1] - tempY == 1) return null;
        return new int[]{target[0], tempY + 1};
    }


//

}
