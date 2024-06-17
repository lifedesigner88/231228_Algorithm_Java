package JavaCodeTest_Non_Linear.B_0054_Minimum_Height_Trees;


// https://leetcode.com/problems/minimum-height-trees/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees {
    public static void main(String[] args) {


        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};

        Solution solution = new Solution();
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        System.out.println(result);

    }
}


// ❤️ Beautiful Solution ❤️


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) return List.of(0);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (graph.get(i).size() == 1) leaves.add(i);

        while (n > 2) {

            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).getFirst();
                graph.get(neighbor).remove((Integer) leaf);
                if (graph.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }

            leaves = newLeaves;
        }
        return leaves;
    }
}