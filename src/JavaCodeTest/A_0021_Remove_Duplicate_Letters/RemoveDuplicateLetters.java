package JavaCodeTest.A_0021_Remove_Duplicate_Letters;

import java.util.*;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {


        String s = "zabcabcabcabceeed";

        UseSetRecurl solution = new UseSetRecurl();
        String result = solution.removeDuplicateLetters(s);
        System.out.println(result);

        UseStack useStack = new UseStack();
        String stackResult = useStack.removeDuplicateLetters(s);
        System.out.println(stackResult);


    }
}


// ❤️ Beautiful Solution ❤️

class UseSetRecurl {
    public String removeDuplicateLetters(String s) {
        for (char word : toSortedSet(s)) {
            String suffix = s.substring(s.indexOf(word));
            if (toSortedSet(s).equals(toSortedSet(suffix))) {
                suffix = suffix.replace(String.valueOf(word), "");
                return word + removeDuplicateLetters(suffix);
            }
        }
        return "";
    }

    Set<Character> toSortedSet(String s) {
        Set<Character> sortedSet = new TreeSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) sortedSet.add(s.charAt(i));
        return sortedSet;
    }
}


class UseStack {
    public String removeDuplicateLetters(String s) {

        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            char word = s.charAt(i);
            counter.put(word, counter.get(word) - 1);
            if (seen.get(word) != null && seen.get(word)) continue;
            while (!stack.isEmpty()
                    && word < stack.peek()
                    && counter.get(stack.peek()) > 0)
                seen.put(stack.pop(), false);
            stack.push(word);
            seen.put(word, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();

    }
}


























