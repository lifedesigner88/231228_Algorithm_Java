package JavaCodeTest.A_0000_Two_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum
// https://blog.naver.com/lifedesigner88/223455176344

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = {0, 1};

        BrusthForce bf = new BrusthForce();
        System.out.println(Arrays.toString(bf.twoSum(nums, target)));

        OnePassHashMap op = new OnePassHashMap();
        System.out.println(Arrays.toString(op.twoSum(nums, target)));

        TwoPassHashMap tp = new TwoPassHashMap();
        System.out.println(Arrays.toString(tp.twoSum(nums, target)));

    }
}

class BrusthForce {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
        return null;
    }
}

class TwoPassHashMap {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) map.put(nums[i], i);
        for (int i = 0; i < n; i++) {
            int subValue = target - nums[i];
            if (map.containsKey(subValue) && map.get(subValue) != i)
                return new int[]{i, map.get(subValue)};
        }
        return null;
    }
}

class OnePassHashMap {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int subValue = target - nums[i];
            if (map.containsKey(subValue))
                return new int[]{map.get(subValue), i};
            map.put(nums[i], i);
        }
        return null;
    }
}