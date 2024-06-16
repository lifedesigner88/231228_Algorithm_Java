package JavaCodeTest_Non_Linear.B_0049_Longest_Univalue_Path;


// https://leetcode.com/problems/longest-univalue-path/

import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import static JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.MaximumDepthOfBinaryTree.arrayToTree;

public class LongestUnivaluePath {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{5, 4, 5, 1, 1, null, 5};
        TreeNode root = arrayToTree(arr);

        Solution solution = new Solution();
        int longestPath = solution.longestUnivaluePath(root);
        System.out.println("Longest Univalue Path: " + longestPath);

    }
}


// ❤️ Beautiful Solution ❤️


class Solution {

    int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        DFS(root);
        return this.result;
    }

    public int DFS(TreeNode node) {
        if (node == null) return 0;
        int left = DFS(node.left);
        int right = DFS(node.right);

        if (node.left != null && node.left.val == node.val)
            left++;
        else left = 0;

        if (node.right != null && node.right.val == node.val)
            right++;
        else right = 0;

        this.result = Math.max(this.result, left + right);
        return Math.max(left, right);
    }
}