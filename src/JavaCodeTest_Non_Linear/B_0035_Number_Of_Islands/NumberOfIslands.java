package JavaCodeTest_Non_Linear.B_0035_Number_Of_Islands;

public class NumberOfIslands {
    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        Solution solution = new Solution();
        int result = solution.numIslands(grid);
        System.out.println(result);

    }
}

// ❤️ Beautiful Solution ❤️

class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == '1') {
                    DFS(i, j, grid);
                    count++;
                }

        return count;
    }

    void DFS(int i, int j, char[][] grid) {
        if (i < 0
                || i >= grid.length
                || j < 0
                || j >= grid[0].length
                || grid[i][j] == '0') return;

        grid[i][j] = '0';
        DFS(i, j + 1, grid);
        DFS(i, j - 1, grid);
        DFS(i + 1, j, grid);
        DFS(i - 1, j, grid);
    }
}