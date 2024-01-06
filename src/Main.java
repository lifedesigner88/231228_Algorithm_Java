import java.util.Arrays;

class Solution extends Print {
    public static void main(String[] args) {

        print(Arrays.deepToString(solution(5)));

    }
    private static final int[][] DIRECTIONS = {
            {0, 1},  // RIGHT
            {1, 0},  // DOWN
            {0, -1}, // LEFT
            {-1, 0}, // UP
    };

    public static int[][] solution(int n) {
        int[][] result = new int[n][n];
        int x = 0, y = 0, directionIndex = 0;

        for (int i = 1; i <= n * n; i++) {
            result[x][y] = i;
            int newX = x + DIRECTIONS[directionIndex % 4][0];
            int newY = y + DIRECTIONS[directionIndex % 4][1];

            if (newX < 0 || newY < 0 || newX == n || newY == n || result[newX][newY] != 0) {
                directionIndex++;   // change direction
                newX = x + DIRECTIONS[directionIndex % 4][0];
                newY = y + DIRECTIONS[directionIndex % 4][1];
            }

            x = newX;
            y = newY;
        }
        return result;
    }
}