package JavaCodeTest_Non_Linear.B_0059_Construct_Tree_From_Preorder_And_Inorder;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static JavaCodeTest_Non_Linear.B_0050_Invert_Binary_Tree.InvertBinaryTree.treeToArray;

public class ConstructTreeFromPreorderAndInorder {
    public static void main(String[] args) {

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        Recursive recursive = new Recursive();
        TreeNode root = recursive.buildTree(preorder, inorder);

        Integer[] result = treeToArray(root);
        System.out.println(Arrays.toString(result));

        UseList useList = new UseList();
        TreeNode answer = useList.buildTree(preorder, inorder);

        Integer[] result2 = treeToArray(answer);
        System.out.println(Arrays.toString(result2));

    }
}


// ❤️ Beautiful Solution ❤️


class Recursive {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return DFS(0, 0, inorder.length - 1, preorder, inorder);
    }

    TreeNode DFS(int preIndex, int inStart, int inEnd,
                 int[] preorder, int[] inorder) {

        if (preIndex > preorder.length - 1 || inStart > inEnd)
            return null;

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++)
            if (inorder[i] == preorder[preIndex])
                inIndex = i;

        preIndex++;
        TreeNode node = new TreeNode(inorder[inIndex]);

        node.left = DFS(preIndex,
                inStart, inIndex - 1,
                preorder, inorder);
        node.right = DFS(preIndex + inIndex - inStart,
                inIndex + 1, inEnd,
                preorder, inorder);

        return node;
    }
}


class UseList {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();

        for (int pre : preorder) preOrder.add(pre);
        for (int in : inorder) inOrder.add(in);

        return DFS(preOrder, inOrder);
    }

    TreeNode DFS(List<Integer> preOrder, List<Integer> inOrder) {
        if (inOrder.isEmpty()) return null;

        int inIndex = inOrder.indexOf(preOrder.getFirst());
        TreeNode node = new TreeNode(inOrder.get(inIndex));

        node.left = DFS(preOrder.subList(1, inIndex + 1),
                        inOrder.subList(0, inIndex));
        node.right = DFS(preOrder.subList(inIndex + 1, preOrder.size()),
                        inOrder.subList(inIndex + 1, inOrder.size()));

        return node;
    }

}