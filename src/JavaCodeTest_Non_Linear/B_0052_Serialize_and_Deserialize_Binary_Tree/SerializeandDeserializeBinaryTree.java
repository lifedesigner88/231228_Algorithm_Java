package JavaCodeTest_Non_Linear.B_0052_Serialize_and_Deserialize_Binary_Tree;


// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

import JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static JavaCodeTest_Non_Linear.B_0047_Maximum_Depth_of_Binary_Tree.MaximumDepthOfBinaryTree.arrayToTree;
import static JavaCodeTest_Non_Linear.B_0050_Invert_Binary_Tree.InvertBinaryTree.treeToArray;

public class SerializeandDeserializeBinaryTree {
    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1, 2, 3, null, null, 4, 5};
        TreeNode root = arrayToTree(arr1);

        Codec ser = new Codec();
        Codec deser = new Codec();

        System.out.println(ser.serialize(root));
        TreeNode ans = deser.deserialize(ser.serialize(root));
        Integer[] result = treeToArray(ans);
        System.out.println(Arrays.toString(result));

    }
}

// ❤️ Beautiful Solution ❤️


class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();
        sb.append(STR."#,\{root.val}");

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                sb.append(",").append(node.left.val);
            } else sb.append(",#");

            if (node.right != null) {
                queue.add(node.right);
                sb.append(",").append(node.right.val);
            } else sb.append(",#");
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 2;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!nodes[index].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.left);
            }

            index += 1;
            if (!nodes[index].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.right);
            }

            index += 1;
        }
        return root;
    }
}