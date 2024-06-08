package JavaCodeTest.A_0030_Design_HashMap;

import java.util.HashMap;

public class DesignHashMap {
    public static void main(String[] args) {


        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
}


// ❤️ Beautiful Solution ❤️


class MyHashMap {

    int hashSize = 1000000;
    final Node[] nodes;

    public MyHashMap() {
        this.nodes = new Node[hashSize];
    }

    public void put(int key, int value) {
        int index = key % hashSize;
        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }
        Node temp = nodes[index];
        while (temp != null) {
            if (temp.key == key) {
                temp.val = value;
                return;
            }
            if (temp.next == null) {
                temp.next = new Node(key, value);
                return;
            }
            temp = temp.next;
        }
    }

    public int get(int key) {
        int index = key % hashSize;
        Node temp = nodes[index];
        while (temp != null) {
            if (temp.key == key) return temp.val;
            temp = temp.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % hashSize;
        Node temp = nodes[index];
        if (temp == null) return;
        if (temp.key == key)
            if (temp.next == null) nodes[index] = null;
            else nodes[index] = temp.next;
        Node prev = temp;
        while (temp != null) {
            if (temp.key == key) {
                prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    static class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

