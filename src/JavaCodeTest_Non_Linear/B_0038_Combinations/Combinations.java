package JavaCodeTest_Non_Linear.B_0038_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.combine(5, 3));

    }
}

// ❤️ Beautiful Solution ❤️


class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> results = new ArrayList<>();
        DFS(results, new ArrayList<>(), 1, n, k);
        return results;

    }

    private void DFS(List<List<Integer>> results,
                     ArrayList<Integer> combination,
                     int start, int n, int k) {

        if (k == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);
            DFS(results, combination, i + 1, n, k - 1);
            combination.removeLast();
        }

    }
}