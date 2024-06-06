package JavaCodeTest.A_0024_Implement_Queue_using_Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueusingStacks {
    public static void main(String[] args) {

        PushOnQue pq = new PushOnQue();
        pq.push(5);
        pq.push(4);
        System.out.print(pq.pop());
        System.out.print(pq.peek());
        System.out.println(pq.empty());


        PopOnQue popQ = new PopOnQue();
        popQ.push(5);
        popQ.push(4);
        System.out.print(popQ.pop());
        System.out.print(popQ.peek());
        System.out.println(popQ.empty());


    }
}


// ❤️ Beautiful Solution ❤️


class PushOnQue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public PushOnQue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        stack1.push(x);
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        if (!stack1.isEmpty())
            return stack1.peek();
        return -99999999;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}


class PopOnQue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public PopOnQue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        peek();
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        if (!stack2.isEmpty())
            return stack2.peek();
        return -1;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}