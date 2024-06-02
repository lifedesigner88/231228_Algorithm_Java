package JavaCodeTest.A_0011_Product_of_Array_Except_Self;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        int[] nums = {-1, 1, 0, -3, 3};
        int[] result = {0, 0, 9, 0, 0};

        LeftRight lr = new LeftRight();
        System.out.println(Arrays.toString(lr.productExceptSelf(nums)));

        MySolution sol = new MySolution();
        System.out.println(Arrays.toString(sol.productExceptSelf(nums)));


    }
}


// ❤️ Beautiful Solution ❤️


class LeftRight {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for (int i = 1; i < n; i++)
            answer[i] = nums[i - 1] * answer[i - 1];

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }

        return answer;
    }
}


// 시간초과
class MySolution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, 1);
        for (int i = 0; i < n; i++)
            multifly(result, i, nums[i]);

        return result;
    }

    void multifly(int[] arr, int index, int value) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            if (index != i) arr[i] *= value;
    }
}