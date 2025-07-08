package src.StackAndQueue_12.Questions;

import java.util.Stack;

public class MyQueue_LC232 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue_LC232() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int removed = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return removed;
    }

    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int peeked = stack2.peek();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return peeked;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue_LC232 myQueue = new MyQueue_LC232();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}


