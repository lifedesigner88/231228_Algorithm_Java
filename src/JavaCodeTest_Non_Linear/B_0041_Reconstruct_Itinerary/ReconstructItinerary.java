package JavaCodeTest_Non_Linear.B_0041_Reconstruct_Itinerary;


// https://leetcode.com/problems/reconstruct-itinerary/description/

import java.util.*;
import java.util.stream.Collectors;

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

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new LinkedList<>();
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            fromToMap.putIfAbsent(ticket.getFirst(), new PriorityQueue<>());
            fromToMap.get(ticket.getFirst()).add(ticket.getLast());
        }

        DFS(results, fromToMap, "JFK");
        return results;
    }

    void DFS(List<String> results,
             Map<String, PriorityQueue<String>> fromToMap,
             String from) {
        while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty())
            DFS(results, fromToMap, fromToMap.get(from).poll());
        results.addFirst(from);
    }
}


class Iteration {
    final String START = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> fromTo = new HashMap<>();
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
            while(fromTo.containsKey(stack.peek())) {
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