package JavaCodeTest.A_0014_Merge_Two_Sorted_Lists;

public class MergeTwoSortedLists {
    public static void main(String[] args) {


        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        list1.next.next.next = new ListNode(8);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(5);
        list2.next.next.next = new ListNode(7);

        Recursive r = new Recursive();
        ListNode result1 = r.mergeTwoLists(list1, list2);

        while (result1 != null) {
            System.out.print(result1.val + ", ");
            result1 = result1.next;
        }


        System.out.println();

        // 리스트 재설정
        list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        list1.next.next.next = new ListNode(8);

        list2 = new ListNode(2);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(5);
        list2.next.next.next = new ListNode(7);


        Assemble a = new Assemble();
        ListNode result2 = a.mergeTwoLists(list1, list2);

        while (result2 != null) {
            System.out.print(result2.val + ", ");
            result2 = result2.next;
        }

    }
}


// ❤️ Beautiful Solution ❤️


class Recursive {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }
}


class Assemble {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(Integer.MIN_VALUE);
        ListNode prev = prehead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        prev.next = list1 == null ? list2 : list1;
        return prehead.next;
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