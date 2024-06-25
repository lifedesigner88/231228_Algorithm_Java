package JavaCodeTest_Non_Linear.B_0058_Minimum_Distance_Between_BST_Nodes;


// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.MaximumDepthOfBinaryTree.arrayToTree;

public class MinimumDistanceBetweenBSTNodes {
    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{4, 2, 6, 1, 3};
        TreeNode root = arrayToTree(arr1);

        Recurlsive solution = new Recurlsive();
        int result = solution.minDiffInBST(root);
        System.out.println(result);

        Iteration iteration = new Iteration();
        int result2 = iteration.minDiffInBST(root);
        System.out.println(result2);


    }
}

// ❤️ Beautiful Solution ❤️


class Recurlsive {

    int prev = Integer.MIN_VALUE + 100000;
    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return -1;

        if (root.left != null) minDiffInBST(root.left);
        minDiff = Math.min(minDiff, root.val - prev);
        prev = root.val;

        if (root.right != null) minDiffInBST(root.right);
        return minDiff;
    }
}


class Iteration {

    public int minDiffInBST(TreeNode root) {

        int prev = Integer.MIN_VALUE + 100000;
        int minDiff = Integer.MAX_VALUE;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            minDiff = Math.min(minDiff, node.val - prev);

            prev = node.val;
            node = node.right;
        }

        return minDiff;
    }
}