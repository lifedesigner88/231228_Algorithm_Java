package JavaCodeTest_Non_Linear.B_0044_Network_Delay_Time;


// https://leetcode.com/problems/network-delay-time/description/

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {

        int[][] arr = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};

        Solution solution = new Solution();
        int result = solution.networkDelayTime(arr, 4, 2);
        System.out.println(result);


    }
}


// ❤️ Beautiful Solution ❤️


// import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            int node = time[0];
            int target = time[1];
            int distance = time[2];

            graph.putIfAbsent(node, new HashMap<>());
            graph.get(node).put(target, distance);
        }

        Queue<Map.Entry<Integer, Integer>> pQue =
                new PriorityQueue<>(Map.Entry.comparingByValue());
        pQue.add(new AbstractMap.SimpleEntry<>(k, 0));
        Map<Integer, Integer> dist = new HashMap<>();

        while (!pQue.isEmpty()) {
            Map.Entry<Integer, Integer> cur = pQue.poll();
            int u = cur.getKey();
            int dist_u = cur.getValue();

            if (!dist.containsKey(u)) {
                dist.put(u, dist_u);
                if (graph.containsKey(u))
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        int alt = dist_u + v.getValue();
                        pQue.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
                    }
            }
        }

        if (dist.size() == n) return Collections.max(dist.values());
        return -1;
    }
}