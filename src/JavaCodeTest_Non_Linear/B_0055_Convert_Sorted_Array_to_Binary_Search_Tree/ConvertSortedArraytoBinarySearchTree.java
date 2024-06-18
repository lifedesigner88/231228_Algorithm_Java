package JavaCodeTest_Non_Linear.B_0055_Convert_Sorted_Array_to_Binary_Search_Tree;

import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import java.util.Arrays;

import static JavaCodeTest_Non_Linear.B_0050_Invert_Binary_Tree.InvertBinaryTree.treeToArray;

public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {

        int [] nums = {-10, -3, 0, 5, 9};
        Solution solution = new Solution();
        TreeNode ans = solution.sortedArrayToBST(nums);

        Integer[] result = treeToArray(ans);
        System.out.println(Arrays.toString(result));

    }
}

// ❤️ Beautiful Solution ❤️

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return construct(nums, 0, nums.length - 1);
    }

    TreeNode construct(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = construct(nums, lo, mid - 1);
        node.right = construct(nums, mid + 1, hi);
        return node;
    }
}