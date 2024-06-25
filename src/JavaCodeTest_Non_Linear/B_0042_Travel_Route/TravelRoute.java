package JavaCodeTest_Non_Linear.B_0042_Travel_Route;

import java.util.*;

public class TravelRoute {
    public static void main(String[] args) {

        String[][] array = {{"ICN", "JFK"}, {"HND", "IAD"}, {"SFO", "SJC"}, {"JFK", "HND"}};

        Solution recursion = new Solution();
        String[] result = recursion.solution(array);
        System.out.println(Arrays.toString(result));
    }
}


// ❤️ Beautiful Solution ❤️

class Solution {

    final String START = "ICN";

    public String[] solution(String[][] tickets) {

        Map<String, Queue<String>> fromTo = new HashMap<>();

        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            fromTo.putIfAbsent(from, new PriorityQueue<>());
            fromTo.get(from).add(to);
        }

        LinkedList<String> answer = new LinkedList<>();
        Deque<String> stack = new LinkedList<>();

        stack.push(START);
        while (!stack.isEmpty()) {
            while (fromTo.containsKey(stack.peek())) {
                Queue<String> toPQue = fromTo.get(stack.peek());
                if (toPQue.isEmpty()) {
                    fromTo.remove(stack.peek());
                    break;
                }
                stack.push(toPQue.poll());
            }
            answer.addFirst(stack.pop());
        }

        return answer.toArray(new String[0]);
    }
}