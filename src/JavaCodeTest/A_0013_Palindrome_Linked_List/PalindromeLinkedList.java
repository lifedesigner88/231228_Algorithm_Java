package JavaCodeTest.A_0013_Palindrome_Linked_List;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);


        UseDeque solution = new UseDeque();
        boolean result = solution.isPalindrome(head);
        System.out.println(result);

    }
}

// ❤️ Beautiful Solution ❤️

class UseDeque {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deQue = new LinkedList<>();

        ListNode node = head;
        while (node != null) {
            deQue.add(node.val);
            node = node.next;
        }

        while (deQue.size() > 1)
            if (deQue.pollFirst() != deQue.pollLast())
                return false;

        return true;
    }
}





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