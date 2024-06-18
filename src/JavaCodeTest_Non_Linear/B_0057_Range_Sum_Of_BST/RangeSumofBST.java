package JavaCodeTest_Non_Linear.B_0057_Range_Sum_Of_BST;


// https://leetcode.com/problems/range-sum-of-bst/

import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.MaximumDepthOfBinaryTree.arrayToTree;

public class RangeSumofBST {
    public static void main(String[] args) {


        Integer[] arr1 = new Integer[]{10, 5, 15, 3, 7, null, 18};
        TreeNode root = arrayToTree(arr1);
        int low = 7;
        int high = 15;

        Pruning solution = new Pruning();
        int result = solution.rangeSumBST(root, low, high);
        System.out.println(result);

        DFSIteration dfs = new DFSIteration();
        int result2 = dfs.rangeSumBST(root, low, high);
        System.out.println(result2);

        BFSIteration bfs = new BFSIteration();
        int result3 = bfs.rangeSumBST(root, low, high);
        System.out.println(result3);

    }
}


// ❤️ Beautiful Solution ❤️

class Pruning {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val > high)
            return rangeSumBST(root.left, low, high);
        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}


class DFSIteration {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val > low && node.left != null)
                stack.push(node.left);
            if (node.val < high && node.right != null)
                stack.push(node.right);
            if (low <= node.val && node.val <= high)
                result += node.val;
        }

        return result;
    }
}


class BFSIteration {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > low && node.left != null)
                queue.add(node.left);
            if (node.val < high && node.right != null)
                queue.add(node.right);
            if (low <= node.val && node.val <= high)
                result += node.val;
        }

        return result;
    }
}