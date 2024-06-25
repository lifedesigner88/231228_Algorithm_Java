package JavaCodeTest_Non_Linear.B_0051_Merge_Two_Binary_Trees;


import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import java.util.Arrays;

import static JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.MaximumDepthOfBinaryTree.arrayToTree;
import static JavaCodeTest_Non_Linear.B_0050_Invert_Binary_Tree.InvertBinaryTree.treeToArray;


// https://leetcode.com/problems/merge-two-binary-trees/description/


public class MergeTwoBinaryTrees {
    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1, 3, 2, 5};
        TreeNode root1 = arrayToTree(arr1);

        Integer[] arr2 = new Integer[]{2, 1, 3, null, 4, null, 7};
        TreeNode root2 = arrayToTree(arr2);

        Solution solution = new Solution();
        TreeNode mergedTree = solution.mergeTrees(root1, root2);
        Integer[] result = treeToArray(mergedTree);
        System.out.println(Arrays.toString(result));

    }
}

// ❤️ Beautiful Solution ❤️


class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}

