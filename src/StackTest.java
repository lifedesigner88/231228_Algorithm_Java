import java.util.NoSuchElementException;

public class StackTest {
    public static void main(String[] args) {

        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());

    }
}




class MyStack {
    MyNode last;

    public void push (int item) {
        this.last = new MyNode(item, last);
    }

    public int pop() {
        int item = this.last.item;
        this.last = last.next;
        return item;
    }
}




class MyNode {
    int item;
    MyNode next;

    public MyNode(int item , MyNode next) {
        this.item = item;
        this.next = next;
    }
}
