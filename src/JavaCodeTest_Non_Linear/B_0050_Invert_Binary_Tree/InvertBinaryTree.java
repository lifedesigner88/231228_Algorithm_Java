package JavaCodeTest_Non_Linear.B_0050_Invert_Binary_Tree;

// https://leetcode.com/problems/invert-binary-tree/description/

import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import java.util.*;

import static JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.MaximumDepthOfBinaryTree.arrayToTree;

public class InvertBinaryTree {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root = arrayToTree(arr);

        NewNode nn = new NewNode();
        TreeNode invertedTree = nn.invertTree(root);
        Integer[] result1 = treeToArray(invertedTree);
        System.out.println(Arrays.toString(result1));

        SwapFromRoot sfr = new SwapFromRoot();
        TreeNode invertedTree2 = sfr.invertTree(root);
        Integer[] result2 = treeToArray(invertedTree2);
        System.out.println(Arrays.toString(result2));

        SwapFromChild sfc = new SwapFromChild();
        TreeNode invertedTree3 = sfc.invertTree(root);
        Integer[] result3 = treeToArray(invertedTree3);
        System.out.println(Arrays.toString(result3));

        IterationDFS dfsi = new IterationDFS();
        TreeNode invertedTree4 = dfsi.invertTree(root);
        Integer[] result4 = treeToArray(invertedTree4);
        System.out.println(Arrays.toString(result4));


        IterationBFS bfs = new IterationBFS();
        TreeNode invertedTree5 = bfs.invertTree(root);
        Integer[] result5 = treeToArray(invertedTree5);
        System.out.println(Arrays.toString(result5));



    }


    // 2진트리를 배열로 출력하는 함수.
    public static Integer[] treeToArray(TreeNode root) {
        if(root == null)
            return new Integer[0];

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                list.add(null);
                continue;
            } else list.add(node.val);

            if (node.left != null || node.right != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        Integer[] array = new Integer[list.size()];
        array = list.toArray(array);

        return array;
    }

}


// ❤️ Beautiful Solution ❤️


class NewNode {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = invertTree(root.right);
        newNode.right = invertTree(root.left);
        return newNode;
    }
}



class SwapFromRoot {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}


class SwapFromChild {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}



class IterationDFS {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()) {

            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);

        }

        return root;
    }
}


class IterationBFS {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);

        }

        return root;
    }
}
