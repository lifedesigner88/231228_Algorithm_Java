package DailyQuestion.LeetCode_2408;


import java.util.Arrays;
import java.util.List;


// 590. N-ary Tree Postorder Traversal
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/editorial/?envType=daily-question&envId=2024-08-26

public class LC_26_01 {
    public static void main(String[] args) {

        Integer[] array = {1, null, 3, 2, 4, null, 5, 6};
        Integer[] array2 =
                {1, null,
                2,      3,          4,      5, null,
                null, 6, 7, null,   8, null,    9,      10, null,
                    null, 11, null, 12, null, 13, null, null,
                            14};

        System.out.println(Arrays.toString(array));

        Solution solution = new Solution();

        Node root = solution.makeNodeToTree(array);

        System.out.println(root.val);

    }


}

class Solution {
    public Node makeNodeToTree(Integer[] array) {

        if (array == null || array.length == 0) return null;

        Node root = new Node(array[0]);

        return root;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};