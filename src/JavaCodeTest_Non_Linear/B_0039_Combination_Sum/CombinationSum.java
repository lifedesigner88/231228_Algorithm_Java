package JavaCodeTest_Non_Linear.B_0039_Combination_Sum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

        int[] candidates = {2, 3, 5, 8, 12};
        int target = 8;

        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);

    }
}

// ❤️ Beautiful Solution ❤️


class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        DFS(results, candidates, target, 0, new ArrayDeque<>());
        return results;
    }

    void DFS(List<List<Integer>> results,
             int[] candidates,
             int target, int index,
             Deque<Integer> path) {

        if (target < 0) return;
        if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            DFS(results, candidates, target - candidates[i], i, path);
            path.removeLast();
        }
    }

}