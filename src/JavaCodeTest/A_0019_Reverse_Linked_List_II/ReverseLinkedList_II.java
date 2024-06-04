package JavaCodeTest.A_0019_Reverse_Linked_List_II;

import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList_II {
    public static void main(String[] args) {

        ListNode list = convertListToListNode(Arrays.asList(1, 2, 3, 4, 5));
        Solution solution = new Solution();
        ListNode result = solution.reverseBetween(list, 2, 4);
        while (result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }

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


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode root = new ListNode();
        root.next = head;

        ListNode start = root;
        for (int i = 0; i < left - 1; i++) start = start.next;

        ListNode end = start.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = temp;
        }
        return root.next;
    }
}


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