package JavaCodeTest.A_0026_Design_Circular_Deque;

public class DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque cd = new MyCircularDeque(3);
        System.out.println(cd.insertFront(1));
        System.out.println(cd.insertLast(2));
        System.out.println(cd.deleteFront());
        System.out.println(cd.deleteLast());

        int front = cd.getFront();
        int rear = cd.getRear();
        boolean isEmpty = cd.isEmpty();
        boolean isFull = cd.isFull();

        System.out.println(front);
        System.out.println(rear);
        System.out.println(isEmpty);
        System.out.println(isFull);

    }
}


// ❤️ Beautiful Solution ❤️


class MyCircularDeque {

    int length;
    int capacity;
    DoublyLinkedList head;
    DoublyLinkedList tail;

    public MyCircularDeque(int k) {
        head = new DoublyLinkedList();
        tail = new DoublyLinkedList();
        head.right = tail;
        tail.left = head;
        this.capacity = k;
        this.length = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        DoublyLinkedList temp = new DoublyLinkedList(value);
        temp.right = head.right;
        temp.left = head;
        head.right.left = temp;
        head.right = temp;
        this.length++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        DoublyLinkedList temp = new DoublyLinkedList(value);
        temp.left = tail.left;
        temp.right = tail;
        tail.left.right = temp;
        tail.left = temp;
        this.length++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        head.right.right.left = head;
        head.right = head.right.right;
        this.length--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail.left.left.right = tail;
        tail.left = tail.left.left;
        this.length--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return head.right.val;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return tail.left.val;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean isFull() {
        return this.length == this.capacity;
    }

    static class DoublyLinkedList {
        int val;
        DoublyLinkedList left;
        DoublyLinkedList right;
        public DoublyLinkedList() {}
        public DoublyLinkedList(int val) {
            this.val = val;
        }
    }
}
