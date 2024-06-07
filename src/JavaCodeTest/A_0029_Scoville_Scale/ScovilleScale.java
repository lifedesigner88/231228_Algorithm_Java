package JavaCodeTest.A_0029_Scoville_Scale;

import java.util.PriorityQueue;

public class ScovilleScale {
    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 4, 9, 10, 12};
        int K = 7;

        Solution s = new Solution();
        System.out.println(s.solution(scoville, K));

    }
}

// ❤️ Beautiful Solution ❤️

//import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pQue = new PriorityQueue<>();
        for (int a : scoville) pQue.add(a);
        int answer = 0;

        while (true) {
            if (pQue.peek() != null && pQue.peek() >= K)
                return answer;
            else if (pQue.size() <= 1) return -1;
            else {
                pQue.add(pQue.poll() + 2 * pQue.poll());
                answer++;
            }
        }
    }
}