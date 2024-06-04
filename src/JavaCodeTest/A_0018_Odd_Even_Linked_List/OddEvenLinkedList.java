package JavaCodeTest.A_0018_Odd_Even_Linked_List;

import java.util.Arrays;
import java.util.List;

public class OddEvenLinkedList {
    public static void main(String[] args) {

        ListNode list = convertListToListNode(Arrays.asList(1, 2, 3, 4, 5));
        Solution solution = new Solution();
        ListNode result = solution.oddEvenList(list);
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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