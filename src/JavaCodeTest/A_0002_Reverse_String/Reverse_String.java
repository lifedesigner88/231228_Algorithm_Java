package JavaCodeTest.A_0002_Reverse_String;

// https://leetcode.com/problems/reverse-string

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Reverse_String {
    public static void main(String[] args) {

        char[] input = {'h', 'e', 'l', 'l', 'o'};
        char[] result = {'o', 'l', 'e', 'l', 'h'};

        UseFor uf = new UseFor();
        uf.reverseString(input);
        System.out.println(Arrays.toString(input));

        UseStack ud = new UseStack();
        ud.reverseString(input);
        System.out.println(Arrays.toString(input));

        TwoPointer ur = new TwoPointer();
        ur.reverseString(input);
        System.out.println(Arrays.toString(input));

    }
}

class UseFor {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }
}

class TwoPointer {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

class UseStack {
    public void reverseString(char[] s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s) stack.push(c);
        int index = 0;
        while (!stack.isEmpty())
            s[index++] = stack.pop();
    }
}




