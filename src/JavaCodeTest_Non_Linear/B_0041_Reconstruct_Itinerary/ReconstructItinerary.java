package JavaCodeTest_Non_Linear.B_0041_Reconstruct_Itinerary;


// https://leetcode.com/problems/reconstruct-itinerary/description/

import java.util.*;
import java.util.stream.Collectors;

public class ReconstructItinerary {
    public static void main(String[] args) {

        String[][] array = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};

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
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
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
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> results = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("JFK");
        while (!stack.isEmpty()) {
            while(fromToMap.containsKey(stack.getFirst())
                    && !fromToMap.get(stack.getFirst()).isEmpty())
                stack.push(fromToMap.get(stack.getFirst()).poll());
            results.addFirst(stack.pop());
        }

        return results;
    }
}