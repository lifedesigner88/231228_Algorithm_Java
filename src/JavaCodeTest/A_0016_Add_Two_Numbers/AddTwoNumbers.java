package JavaCodeTest.A_0016_Add_Two_Numbers;


// https://leetcode.com/problems/add-two-numbers/


import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l1 = convertListToListNode(Arrays.asList(2, 4, 3));
        ListNode l2 = convertListToListNode(Arrays.asList(5, 6, 4));

        UseBigInt ub = new UseBigInt();
        ListNode result = ub.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();

        ListNode l3 = convertListToListNode(Arrays.asList(2, 4, 3));
        ListNode l4 = convertListToListNode(Arrays.asList(5, 6, 4));

        UseCarry uc = new UseCarry();
        ListNode result2 = uc.addTwoNumbers(l3, l4);
        while (result2 != null) {
            System.out.print(result2.val);
            result2 = result2.next;
        }
        System.out.println();

    }

// 리스트를 노드로 만드는 함수.
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


// import java.math.BigInteger;

class UseBigInt {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        while (l1 != null) {
            str1.insert(0, l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            str2.insert(0, l2.val);
            l2 = l2.next;
        }

        BigInteger big1 = new BigInteger(str1.toString());
        BigInteger big2 = new BigInteger(str2.toString());
        String sumStr = big1.add(big2).toString();

        int n = sumStr.length();
        ListNode answer = null;
        for (int i = 0; i < n; i++) {
            int val = Character.getNumericValue(sumStr.charAt(i));
            answer = addNodeToHead(answer, val);
        }
        return answer;
    }

    ListNode addNodeToHead (ListNode head, int val){
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        return newNode;
    }
}


class UseCarry {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode pointer = root;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            pointer.next = new ListNode(carry % 10);
            carry /= 10;
            pointer = pointer.next;
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