package JavaCodeTest_Non_Linear.B_0056_Binary_Search_Tree_to_Greater_Sum_Tree;

import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import java.util.Arrays;

import static JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.MaximumDepthOfBinaryTree.arrayToTree;
import static JavaCodeTest_Non_Linear.B_0050_Invert_Binary_Tree.InvertBinaryTree.treeToArray;

public class BinarySearchTreetoGreaterSumTree {
    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode root = arrayToTree(arr1);

        Solution solution = new Solution();
        TreeNode ans = solution.bstToGst(root);

        Integer[] result = treeToArray(ans);
        System.out.println(Arrays.toString(result));

    }
}


// ❤️ Beautiful Solution ❤️


class Solution {

    int val = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            val += root.val;
            root.val = val;
            bstToGst(root.left);
        }
        return root;
    }
}