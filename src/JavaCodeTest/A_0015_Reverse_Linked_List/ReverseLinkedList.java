package JavaCodeTest.A_0015_Reverse_Linked_List;

// https://leetcode.com/problems/reverse-linked-list/description/

public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RevNode revNode = new RevNode();
        ListNode rh = revNode.reverseList(head);
        while (rh != null) {
            System.out.print(rh.val + ", ");
            rh = rh.next;
        }

        System.out.println();

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(1);


        Recursive rs = new Recursive();
        ListNode rr = rs.reverseList(head2);
        while (rr != null) {
            System.out.print(rr.val + ", ");
            rr = rr.next;
        }


    }
}



// ❤️ Beautiful Solution ❤️


class RevNode {
    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = rev;
            rev = head;
            head = temp;
        }
        return rev;
    }
}


class Recursive {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
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