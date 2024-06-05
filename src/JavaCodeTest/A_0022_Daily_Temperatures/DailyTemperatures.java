package JavaCodeTest.A_0022_Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public static void main(String[] args) {

        int[] temp = {5,2,3,6,5,6,2,0,9,11};

        UseStack us = new UseStack();
        System.out.println(Arrays.toString(us.dailyTemperatures(temp)));

        GeniusAns ga = new GeniusAns();
        System.out.println(Arrays.toString(ga.dailyTemperatures(temp)));


    }
}


// ❤️ Beautiful Solution ❤️

class UseStack {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int today = 0; today < n; today++) {
            while (!stack.isEmpty()
                    && temperatures[stack.peek()] < temperatures[today]) {
                int last = stack.pop();
                result[last] = today - last;
            }
            stack.push(today);
        }
        return result;
    }
}


class GeniusAns {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int[] result = new int[n];

        for (int today = n - 1; today >= 0; today--) {
            int todayTemp = temperatures[today];
            if (hottest <= todayTemp) {
                hottest = todayTemp;
                continue;
            }
            int days = 1;
            while (todayTemp >= temperatures[today + days])
                days += result[today + days];
            result[today] = days;
        }

        return result;
    }
}