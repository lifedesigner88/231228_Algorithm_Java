package JavaCodeTest.A_0027_Merge_k_Sorted_Lists;


// https://leetcode.com/problems/merge-k-sorted-lists/description/

import java.util.*;

public class MergekSortedLists {
    public static void main(String[] args) {

        ListNode[] lists = new ListNode[3];

        List<List<Integer>> dataForLists = Arrays.asList(
                Arrays.asList(1, 4, 5),
                Arrays.asList(1, 3, 4),
                Arrays.asList(2, 6)
        );


        int counter = 0;
        for (List<Integer> sublist : dataForLists) {
            ListNode tempNode = convertListToListNode(sublist);
            lists[counter++] = tempNode;
        }

        ThreePQue threepQue = new ThreePQue();
        ListNode result = threepQue.mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }

        System.out.println();

        counter = 0;
        for (List<Integer> sublist : dataForLists) {
            ListNode tempNode = convertListToListNode(sublist);
            lists[counter++] = tempNode;
        }

        InsertAll insertAll = new InsertAll();
        ListNode result2 = insertAll.mergeKLists(lists);
        while (result2 != null) {
            System.out.print(result2.val + ", ");
            result2 = result2.next;
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


class ThreePQue {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pQue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.val));

        ListNode root = new ListNode();
        ListNode tail = root;

        for (ListNode node : lists)
            if (node != null) pQue.add(node);

        while (!pQue.isEmpty()) {
            tail.next = pQue.poll();
            tail = tail.next;

            if (tail.next != null)
                pQue.add(tail.next);
        }

        return root.next;
    }
}

class InsertAll {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pQue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.val));

        ListNode root = new ListNode();
        ListNode tail = root;

        for (ListNode node : lists)
            while (node != null) {
                pQue.add(node);
                node = node.next;
            }

        while (!pQue.isEmpty()) {
            tail.next = pQue.poll();
            tail.next.next = null;
            tail = tail.next;
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