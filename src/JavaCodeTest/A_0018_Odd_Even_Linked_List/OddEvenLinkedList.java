package JavaCodeTest.A_0018_Odd_Even_Linked_List;

import java.util.Arrays;
import java.util.List;

public class OddEvenLinkedList {
    public static void main(String[] args) {

        ListNode list = convertListToListNode(Arrays.asList(1, 2, 3, 4, 5));





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