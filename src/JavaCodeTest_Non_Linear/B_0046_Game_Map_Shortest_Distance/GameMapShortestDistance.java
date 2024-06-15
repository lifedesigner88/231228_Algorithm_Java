package JavaCodeTest_Non_Linear.B_0046_Game_Map_Shortest_Distance;

import java.util.*;


// https://school.programmers.co.kr/learn/courses/30/lessons/1844

public class GameMapShortestDistance {
    public static void main(String[] args) {

        UseArray solution = new UseArray();
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1}};
        int shortestDistance = solution.solution(maps);
        System.out.println("Shortest Distance: " + shortestDistance);


        UseRecursive useRecursive = new UseRecursive();
        int answer2 = useRecursive.solution(maps);
        System.out.println("Shortest Distance Recursive: " + answer2);


    }
}


// ❤️ Beautiful Solution ❤️


class UseArray {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {

        int row = maps.length - 1;
        int col = maps[0].length - 1;

        int[][] score = new int[row + 1][col + 1];
        func(maps, score, row + 1, col + 1);
        return score[row][col] == 0 ? -1 : score[row][col];

    }

    void func(int[][] maps, int[][] score, int row, int col) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        score[0][0] = 1;

        while (!q.isEmpty()) {
            int[] next = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = next[0] + dx[i];
                int ny = next[1] + dy[i];
                if (nx >= row || nx < 0 || ny >= col || ny < 0)
                    continue;
                if (maps[nx][ny] == 1 && score[nx][ny] == 0) {
                    score[nx][ny] = score[next[0]][next[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}


class UseRecursive {

    Queue<Position> pQue = new PriorityQueue<>(
            Comparator.comparingInt(o -> o.distance));

    public int solution(int[][] maps) {

        pQue.add(new Position(0, 0, 1));
        Map<Integer, Position> dist = new LinkedHashMap<>();

        while (!pQue.isEmpty()) {

            Position cur = pQue.poll();
            if (!dist.containsKey(cur.y * 1000 + cur.x)) {
                dist.put(cur.y * 1000 + cur.x, cur);
                findPath(cur.y, cur.x + 1, cur.distance, maps);
                findPath(cur.y, cur.x - 1, cur.distance, maps);
                findPath(cur.y + 1, cur.x, cur.distance, maps);
                findPath(cur.y - 1, cur.x, cur.distance, maps);
            }
        }

        int row = maps.length - 1;
        int col = maps[0].length - 1;
        if (dist.containsKey(row * 1000 + col))
            return dist.get(row * 1000 + col).distance;

        return -1;
    }

    void findPath(int y, int x, int distance, int[][] maps) {
        if (y >= 0
                && x >= 0
                && y < maps.length
                && x < maps[0].length
                && maps[y][x] != 0) {
            maps[y][x] = 0;
            pQue.add(new Position(y, x, distance + 1));
        }
    }

    // Java 17 문법
    record Position(int y, int x, int distance) {
    }

/*  record 로 생략가능한 코드.
    static class Position {
        final int y;
        final int x;
        final int distance;

        public Position(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
*/

}