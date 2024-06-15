package JavaCodeTest_Non_Linear.B_0045_Cheapest_Flights_Within_K_Stops;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {

        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int K = 1;


        Solution solution = new Solution();
        int result = solution.findCheapestPrice(flights.length, flights, src, dst, K);
        System.out.println(result);

    }
}



class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] flight : flights) {

            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, price);
        }

        Queue<List<Integer>> pQue =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        pQue.add(Arrays.asList(src, 0, 0));

        Map<Integer, Integer> visited = new HashMap<>();

        while (!pQue.isEmpty()) {
            List<Integer> cur = pQue.poll();

            int u = cur.get(0);
            int price_u  = cur.get(1);
            int k_visited = cur.get(2);

            if (u == dst) return price_u;
            visited.put(u, k_visited);

            if (k_visited++ <= k && graph.containsKey(u))
                for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet())
                    if (!visited.containsKey(v.getKey())
                            || k_visited < visited.get(v.getKey())) {
                        int alt = price_u + v.getValue();
                        pQue.add(Arrays.asList(v.getKey(), alt, k_visited));
                    }
        }

        return -1;
    }
}