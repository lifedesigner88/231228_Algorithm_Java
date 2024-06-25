package JavaCodeTest_Non_Linear.B_0048_Diameter_of_Binary_Tree;

// https://leetcode.com/problems/diameter-of-binary-tree/description/

import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import static JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.MaximumDepthOfBinaryTree.arrayToTree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        TreeNode root = arrayToTree(arr);

        Solution solution = new Solution();
        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of binary tree: " + diameter);

    }
}


// ❤️ Beautiful Solution ❤️


class Solution {
    int longest = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        DFS(root);
        return this.longest;
    }

    public int DFS(TreeNode node) {
        if (node == null) return -1;
        int left = DFS(node.left);
        int right = DFS(node.right);
        this.longest = Math.max(this.longest, left + right + 2);
        return Math.max(left, right) + 1;
    }

}