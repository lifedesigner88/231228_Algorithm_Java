package JavaCodeTest.A_008_Trapping_Rain_Water;

public class Trapping_Rain_Water {
    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        MySolution my = new MySolution();
        System.out.println(my.trap(height));

        TwoPointer tp = new TwoPointer();
        System.out.println(tp.trap(height));


    }

}


// ❤️ Beautiful Solution ❤️

class TwoPointer {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxLeft = height[left];
        int maxRight = height[right];

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