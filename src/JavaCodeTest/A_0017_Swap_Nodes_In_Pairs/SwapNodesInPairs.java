package JavaCodeTest.A_0017_Swap_Nodes_In_Pairs;

import java.util.Arrays;
import java.util.List;

public class SwapNodesInPairs {
    public static void main(String[] args) {

        ListNode list = convertListToListNode(Arrays.asList(1, 2, 3, 4, 5));

        ListNode result = new MySolution().swapPairs(list);

        ListNode pointer = result;
        while (pointer != null) {
            System.out.print(pointer.val + ", ");
            pointer = pointer.next;
        }


        System.out.println();

        ListNode pointer2 = new Reculsive().swapPairs(result);
        while (pointer2 != null) {
            System.out.print(pointer2.val + ", ");
            pointer2 = pointer2.next;
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

class MySolution {
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode();
        ListNode prev = root;
        root.next = head;
        while (head != null && head.next != null) {
            head = swap(prev, head);
            prev = prev.next.next;
        }
        return root.next;
    }

    ListNode swap(ListNode before, ListNode first) {
        ListNode second = first.next;
        ListNode third = first.next.next;
        before.next = second;
        second.next = first;
        first.next = third;
        return third;
    }
}


class Reculsive {
    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            ListNode pointer = head.next;
            head.next = swapPairs(head.next.next);
            pointer.next = head;
            return pointer;
        }
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