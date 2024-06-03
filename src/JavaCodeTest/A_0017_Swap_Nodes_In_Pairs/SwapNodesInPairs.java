package JavaCodeTest.A_0017_Swap_Nodes_In_Pairs;

import java.util.Arrays;
import java.util.List;

public class SwapNodesInPairs {
    public static void main(String[] args) {

      ListNode list = convertListToListNode(Arrays.asList(1, 2, 3, 4));



    }


    static ListNode convertListToListNode(List<Integer> list) {
        if (list == null || list.isEmpty()) return null;
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        for (int value : list) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummyHead.next;
    }
}

// ❤️ Beautiful Solution ❤️






// ListNode Class
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}