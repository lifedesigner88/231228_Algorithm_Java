package JavaCodeTest.A_0010_Array_Partition;

import java.util.Arrays;


// https://leetcode.com/problems/array-partition/


public class ArrayPartition {
    public static void main(String[] args) {

        int[] nums = {6, 2, 6, 5, 1, 2};
        int result = 9;


        AddEven addEven = new AddEven();
        System.out.println(addEven.arrayPairSum(nums));

        UseArray useArray = new UseArray();
        System.out.println(useArray.arrayPairSum(nums));

    }
}

// ❤️ Beautiful Solution ❤️


class AddEven {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i = i + 2 )
            sum += nums[i];
        return sum;
    }
}


class UseArray {
    final static int K = 10000;
    public int arrayPairSum(int[] nums) {

        int[] counter = new int[2 * K + 1];
        for (int num : nums) counter[num + K]++;

        int maxSum = 0;
        boolean switchVal = true;
        for (int num = K; num <= 2 * K; num++)
            while (counter[num] > 0) {
                maxSum += (switchVal ? num - K : 0);
                switchVal = !switchVal;
                counter[num]--;
            }
        return maxSum;
    }
}