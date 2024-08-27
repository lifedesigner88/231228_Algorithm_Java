package DailyQuestion.LeetCode_2408;


import java.util.*;


// 590. N-ary Tree Postorder Traversal
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/editorial/?envType=daily-question&envId=2024-08-26

public class LC_26_01 {
    public static void main(String[] args) {

        Integer[] array = {1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14};

        Solution solution = new Solution();
        Node root = solution.makeNodeToTree(array);

        System.out.println(Arrays.toString(array));

        System.out.println(solution.postorder(root));
        System.out.println(solution.postorderIter(root));

    }

}

class Solution {
    public Node makeNodeToTree(Integer[] array) {

        if (array == null || array.length == 0) return null;

        Node root = new Node(array[0], new ArrayList<>());
        Node header = root;

        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);

        for (int i = 1; i < array.length; i++)
            if (array[i] != null) {
                Node node = new Node(array[i], new ArrayList<>());
                queue.addLast(node);
                header.children.addLast(node);
            } else
                header = queue.removeFirst();

        return root;
    }

    // ⭐reculsive

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        traversePostorder(root, result);
        return result;
    }

    private void traversePostorder(Node currentNode, List<Integer> postorderList) {
        if (currentNode == null) return;
        for (Node childNode : currentNode.children)
            traversePostorder(childNode, postorderList);
        postorderList.add(currentNode.val);
    }


    // ✅iterative

    public List<Integer> postorderIter(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<NodeVisitPair> stack = new ArrayDeque<>();
        stack.push(new NodeVisitPair(root, false));

        while (!stack.isEmpty()) {
            NodeVisitPair currentPair = stack.pop();

            if (currentPair.isVisited) {
                // If the node has been visited, add its value to the result
                result.add(currentPair.node.val);
            } else {
                // Mark the current node as visited and push it back to the stack
                currentPair.isVisited = true;
                stack.push(currentPair);

                // Push all children to the stack in reverse order
                List<Node> children = currentPair.node.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(new NodeVisitPair(children.get(i), false));
                }
            }
        }

        return result;
    }


}

class NodeVisitPair {

    Node node;
    boolean isVisited;

    NodeVisitPair(Node node, boolean isVisited) {
        this.node = node;
        this.isVisited = isVisited;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};