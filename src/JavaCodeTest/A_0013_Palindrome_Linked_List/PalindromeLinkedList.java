package JavaCodeTest.A_0013_Palindrome_Linked_List;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class PalindromeLinkedList {
    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean result = true;


        UseDeque solution = new UseDeque();
        boolean result1 = solution.isPalindrome(head);
        System.out.println(result1);

        SlowFast sf = new SlowFast();
        boolean result2 = sf.isPalindrome(head);
        System.out.println(result2);

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

        while (deQue.size() > 1) {
            Integer first = deQue.pollFirst();
            Integer second = deQue.pollLast();
            if (!Objects.equals(first, second))
                return false;
        }

        return true;
    }
}



class SlowFast {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;

        ListNode rev = null;
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }

        ListNode node = head;
        while (rev != null) {
            if (rev.val != node.val) return false;
            rev = rev.next;
            node = node.next;
        }

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