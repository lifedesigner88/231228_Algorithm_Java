import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        Deque<Integer> deQue = new ArrayDeque<>();


        for (int a : arr)
            if (stack.isEmpty() || stack.peek() != a) stack.push(a);

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}gi