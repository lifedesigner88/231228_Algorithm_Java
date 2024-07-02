package JavaCodeTest_Non_Linear.B_0040_Subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


// https://leetcode.com/problems/subsets/description/

public class Subsets {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);

    }
}


// ❤️ Beautiful Solution ❤️

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        DFS(results, nums, 0, new ArrayDeque<>());
        return results;
    }

    void DFS(List<List<Integer>> results,
             int[] nums, int index,
             Deque<Integer> path) {

        results.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            DFS(results, nums, i + 1, path);
            path.removeLast();
        }

    }
}