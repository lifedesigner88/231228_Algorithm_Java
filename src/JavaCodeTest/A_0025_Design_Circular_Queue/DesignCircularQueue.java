package JavaCodeTest.A_0025_Design_Circular_Queue;

public class DesignCircularQueue {
    public static void main(String[] args) {

        UseArray mq = new UseArray(3);

        System.out.println(mq.enQueue(5));
        System.out.println(mq.enQueue(4));
        System.out.println(mq.enQueue(3));
        System.out.println(mq.enQueue(2));
        System.out.println(mq.deQueue());
        System.out.println(mq.Front());
        System.out.println(mq.Rear());

        System.out.println();

        UseLinkedNode un = new UseLinkedNode(3);
        System.out.println(un.enQueue(1));
        System.out.println(un.enQueue(2));
        System.out.println(un.enQueue(3));
        System.out.println(un.enQueue(4));
        System.out.println(un.deQueue());
        System.out.println(un.Front());
        System.out.println(un.Rear());


    }
}


// ❤️ Beautiful Solution ❤️

class UseArray {

    int[] cQue;
    int front = 0;
    int rear = -1;
    int length = 0;

    public UseArray(int k) {
        this.cQue = new int[k];
    }

    public boolean enQueue(int value) {
        if (!this.isFull()) {
            this.rear = ++this.rear % this.cQue.length;
            cQue[rear] = value;
            this.length++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (!this.isEmpty()) {
            this.front = ++this.front % this.cQue.length;
            this.length--;
            return true;
        }
        return false;
    }

    public int Front() {
        if (!this.isEmpty()) return this.cQue[this.front];
        return -1;
    }

    public int Rear() {
        if (!this.isEmpty()) return this.cQue[this.rear];
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean isFull() {
        return this.cQue.length == this.length;
    }
}


class UseLinkedNode {

    private Node head;
    private Node tail;

    private int count;
    private final int capacity;

    public UseLinkedNode(int k) {
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        Node newNode = new Node(value);
        if (isEmpty()) this.head = newNode;
        else tail.next = newNode;
        this.tail = newNode;
        this.count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        this.head = this.head.next;
        this.count--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        else return this.head.val;
    }

    public int Rear() {
        if (isEmpty()) return -1;
        else return this.tail.val;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }
}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}