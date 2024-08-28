package DailyQuestion.LeetCode_2408;

// 1514. Path with Maximum Probability
// https://leetcode.com/problems/path-with-maximum-probability/description/?envType=daily-question&envId=2024-08-27

public class LC_27_01 {
    public static void main(String[] args) {

        Solution2701 s = new Solution2701();

        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.3};
        int start = 0;
        int end = 2;

        double ans = s.maxProbability(n, edges, succProb, start, end);
        System.out.println(ans);

    }

}

class Solution2701 {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean hasUpdate = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double pathProb = succProb[j];
                if (maxProb[u] * pathProb > maxProb[v]) {
                    maxProb[v] = maxProb[u] * pathProb;
                    hasUpdate = true;
                }
                if (maxProb[v] * pathProb > maxProb[u]) {
                    maxProb[u] = maxProb[v] * pathProb;
                    hasUpdate = true;
                }
            }
            if (!hasUpdate) break;
        }

        return maxProb[end];
    }

}

