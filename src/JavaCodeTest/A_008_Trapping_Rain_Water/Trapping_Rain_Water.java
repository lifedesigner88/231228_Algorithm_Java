package JavaCodeTest.A_008_Trapping_Rain_Water;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/trapping-rain-water
// https://blog.naver.com/lifedesigner88/223465496078

public class Trapping_Rain_Water {
    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = 6;

        MySolution my = new MySolution();
        System.out.println(my.trap(height));

        TwoPointer tp = new TwoPointer();
        System.out.println(tp.trap(height));

        UseStack us = new UseStack();
        System.out.println(us.trap(height));


    }

}


// ❤️ Beautiful Solution ❤️

class TwoPointer {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;
        int water = 0;

        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if (maxLeft < maxRight)
                water += maxLeft - height[left++];
            else
                water += maxRight - height[right--];
        }

        return water;
    }
}


class UseStack {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();

        int water = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer top = stack.pop();
                if (stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int wHeight = Math.min(height[stack.peek()], height[i]);
                int waters = wHeight - height[top];
                water += distance * waters;
            }
            stack.push(i);
        }
        return water;
    }
}


// 시간초과.
class MySolution {
    public int trap(int[] height) {
        int n = height.length;

        int start = 0;
        int end = n - 1;

        int yCheck = 1;
        int result = 0;

        while (start < end) {
            while (start < n && height[start] < yCheck) start++;
            while (end >= 0 && height[end] < yCheck) end--;
            for (int i = start + 1; i < end; i++)
                if (height[i] < yCheck) result++;
            yCheck++;
        }
        return result;

    }
}