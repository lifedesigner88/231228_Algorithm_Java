package JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode root = arrayToTree(arr);

        UseIteration ui = new UseIteration();
        int maxDepth = ui.maxDepth(root);
        System.out.println(STR."Maximum Depth of Binary Tree: \{maxDepth}");

        UseRecursive ur = new UseRecursive();
        int maxDepthRecursive = ur.maxDepth(root);
        System.out.println(STR."Maximum Depth of Binary Tree: \{maxDepthRecursive} ");


    }


    // 배열을 트리로 만들어 주는 함수.
    public static TreeNode arrayToTree(Integer[] arr) {
        if (arr.length == 0) return null;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        nodeQueue.add(root);

        int index = 1;
        while (index < arr.length) {
            TreeNode node = nodeQueue.poll();
            if (node != null) {
                if (arr[index] != null) {
                    node.left = new TreeNode(arr[index]);
                    nodeQueue.add(node.left);
                }
                if ((index + 1) < arr.length && arr[index + 1] != null) {
                    node.right = new TreeNode(arr[index + 1]);
                    nodeQueue.add(node.right);
                }
                index += 2;
            }
        }
        return root;
    }


}


// ❤️ Beautiful Solution ❤️


class UseIteration {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int q_size = queue.size();
            for (int i = 0; i < q_size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    if (cur.left != null)
                        queue.add(cur.left);
                    if (cur.right != null)
                        queue.add(cur.right);
                }
            }
            depth++;
        }

        return depth;
    }
}


class UseRecursive {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}








