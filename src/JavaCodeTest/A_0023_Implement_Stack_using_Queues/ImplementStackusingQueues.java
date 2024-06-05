package JavaCodeTest.A_0023_Implement_Stack_using_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
    public static void main(String[] args) {


        PushOnStack myStack = new PushOnStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.print(myStack.pop());
        System.out.print(myStack.top());
        System.out.print(myStack.pop());
        System.out.println(myStack.empty());


        PopOnStack myStack2 = new PopOnStack();

        myStack2.push(1);
        myStack2.push(2);
        myStack2.push(3);

        System.out.print(myStack2.pop());
        System.out.print(myStack2.top());
        System.out.print(myStack2.pop());
        System.out.println(myStack2.empty());


    }
}


// ❤️ Beautiful Solution ❤️

class PushOnStack {

    Queue<Integer> queue;

    public PushOnStack() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++)
            queue.add(queue.remove());
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        if (!queue.isEmpty()) return queue.peek();
        return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}


class PopOnStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;

    public PopOnStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    public int pop() {
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return queue2.remove();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}