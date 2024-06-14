package JavaCodeTest_Non_Linear.B_0041_Reconstruct_Itinerary;


// https://leetcode.com/problems/reconstruct-itinerary/description/

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {

        String[][] array = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};

        List<List<String>> list = Arrays.stream(array)
                .map(Arrays::asList)
                .toList();

        Recursion recursion = new Recursion();
        List<String> itinerary = recursion.findItinerary(list);
        System.out.println(itinerary);


        Iteration iteration = new Iteration();
        List<String> itinerary2 = iteration.findItinerary(list);
        System.out.println(itinerary2);


    }
}

// ❤️ Beautiful Solution ❤️


class Recursion {

    final String START = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, Queue<String>> fromTo = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.getFirst();
            String to = ticket.getLast();

            fromTo.putIfAbsent(from, new PriorityQueue<>());
            fromTo.get(from).add(to);
        }

        List<String> results = new LinkedList<>();
        DFS(results, fromTo, START);
        return results;
    }

    void DFS(List<String> results,
             Map<String, Queue<String>> fromTo, String from) {
        while (fromTo.containsKey(from) && !fromTo.get(from).isEmpty())
            DFS(results, fromTo, fromTo.get(from).poll());
        results.addFirst(from);
    }
}


class Iteration {

    final String START = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, Queue<String>> fromTo = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.getFirst();
            String to = ticket.getLast();

            fromTo.putIfAbsent(from, new PriorityQueue<>());
            fromTo.get(from).add(to);
        }

        List<String> results = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();

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
            results.addFirst(stack.pop());
        }

        return results;
    }

}