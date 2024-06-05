package JavaCodeTest.A_0020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;



// https://leetcode.com/problems/valid-parentheses/

public class ValidParentheses {
    public static void main(String[] args) {

        String s = "()(){}[][]";

        Solution solution = new Solution();
        boolean isValid = solution.isValid(s);
        System.out.println(isValid);

    }
}


class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> table = new HashMap<>() {{
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if (!table.containsKey(temp))
                stack.push(temp);
            else if (stack.isEmpty() || stack.pop() != table.get(temp))
                return false;
        }

        return stack.isEmpty();
    }
}