package src.StackAndQueue_12.Questions;

import java.util.Stack;

public class MyQueue_RemoveEfficient {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue_RemoveEfficient() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void push(int x) throws Exception {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        MyQueue_RemoveEfficient myQueue = new MyQueue_RemoveEfficient();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
