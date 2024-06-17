package JavaCodeTest_Non_Linear.B_0053_Balanced_Binary_Tree;


// https://leetcode.com/problems/balanced-binary-tree/

import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import static JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.MaximumDepthOfBinaryTree.arrayToTree;

public class BalancedBinaryTree {
    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1, 2, 2, 3, 3, null, null, 4, 5};
        TreeNode root = arrayToTree(arr1);

        Solution solution = new Solution();
        boolean isBalanced = solution.isBalanced(root);
        System.out.println(isBalanced);


    }
}


// ❤️ Beautiful Solution ❤️

class Solution {
    public boolean isBalanced(TreeNode root) {
        return DFS(root) != -1;
    }

    int DFS(TreeNode node) {
        if (node == null) return 0;
        int left = DFS(node.left);
        int right = DFS(node.right);
        if (left == -1
                || right == -1
                || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}