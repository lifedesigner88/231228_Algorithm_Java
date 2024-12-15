package Programers.Lv2.D2412;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/250136
public class P029_석유시추 {

    private int[][] land;
    private int[][] oilId;
    private int row, col;
    private int groupId;
    private final Map<Integer, Integer> oilSizeMap = new HashMap<>(); // <groupId , oilSize>

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public int solution1(int[][] land) {
        this.land = land;
        this.row = land.length;
        this.col = land[0].length;
        this.oilId = new int[row][col];

        Set<Integer> set = new HashSet<>(); // 이미 시추한 석유 그룹 저장

        int maxOil = 0;
        for (int i = 0; i < col; i++) {
            int getedOil = 0; // 시추할 오일의 합
            set.clear();
            for (int j = 0; j < row; j++) {
                if (land[j][i] == 1 && oilId[j][i] == 0)
                    oilSizeMap.put(++groupId, findSizeBFS(j, i));

                int forGetOilId = oilId[j][i]; // 시추할 석유 그룹
                if (!set.contains(forGetOilId) && oilSizeMap.containsKey(forGetOilId)) {
                    getedOil += oilSizeMap.get(forGetOilId);
                    set.add(forGetOilId);
                }
            }
            maxOil = Math.max(maxOil, getedOil);
        }

        return maxOil;
    }

    private int findSizeBFS(int r, int c) {
        Queue<int[]> Que = new ArrayDeque<>();
        Que.offer(new int[]{r, c});
        oilId[r][c] = groupId;
        int oilSize = 1;

        while (!Que.isEmpty()) {
            int[] target = Que.poll();
;
            for (int k = 0; k < 4; k++) {
                int Sx = target[0] + dx[k];
                int Sy = target[1] + dy[k];

                if (0 <= Sx && Sx < row && 0 <= Sy && Sy < col
                        && land[Sx][Sy] == 1 && oilId[Sx][Sy] == 0) {
                    Que.offer(new int[]{Sx, Sy});
                    oilId[Sx][Sy] = groupId;
                    oilSize++;
                }
            }
        }
        return oilSize;
    }


    public int solution2(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        // 덩어리를 탐색하여 ID를 부여하고 크기를 저장
        int[][] group = new int[n][m];
        Map<Integer, Integer> groupSizes = new HashMap<>();
        int groupId = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && group[i][j] == 0) {
                    int size = bfs(land, group, i, j, groupId);
                    groupSizes.put(groupId, size);
                    groupId++;
                }
            }
        }

        // 각 열별 최대 석유량 계산
        int maxOil = 0;

        for (int col = 0; col < m; col++) {
            Set<Integer> visitedGroups = new HashSet<>();
            int totalOil = 0;

            for (int row = 0; row < n; row++) {
                int currentGroupId = group[row][col];
                if (currentGroupId > 0 && !visitedGroups.contains(currentGroupId)) {
                    totalOil += groupSizes.get(currentGroupId);
                    visitedGroups.add(currentGroupId);
                }
            }

            maxOil = Math.max(maxOil, totalOil);
        }

        return maxOil;
    }

    // BFS를 사용하여 석유 덩어리 탐색 및 ID 부여
    private int bfs(int[][] land, int[][] group, int startRow, int startCol, int groupId) {
        int n = land.length;
        int m = land[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        group[startRow][startCol] = groupId;

        int size = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            size++;

            for (int d = 0; d < 4; d++) {
                int newRow = row + dr[d];
                int newCol = col + dc[d];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                        land[newRow][newCol] == 1 && group[newRow][newCol] == 0) {
                    group[newRow][newCol] = groupId;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        return size;
    }
}
