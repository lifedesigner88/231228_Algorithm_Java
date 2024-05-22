package JavaCodeTest.A_0001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {



    }
}


class BrusthForce {
    public int[] twoSum(int[] nums, int target) {
        int nlength = nums.length;
        for ( int i = 0; i < nlength; i++ )
            for ( int j = i + 1; j < nlength; j++ )
                if ( nums[i] + nums[j] == target )
                    return new int[]{i , j};
        return null;
    }
}

class TwoPassHashMap {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(nums[i], i);
        for (int i = 0; i < n; i++) {
            int subValue = target - nums[i];
            if (map.containsKey(subValue) && map.get(subValue) !=i )
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