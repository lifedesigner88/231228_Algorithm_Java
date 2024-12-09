package Programers.Lv1.D2412;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class P023_포켓몬 {

    public int solution1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        int s = set.size();
        int n = nums.length / 2;
        return Math.min(s, n);
    }

    public int solution2(int[] nums) {
        return Math.min(nums.length / 2, (int) Arrays.stream(nums).distinct().count());
    }

}
