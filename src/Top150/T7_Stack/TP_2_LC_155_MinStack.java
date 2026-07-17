package src.Top150.T7_Stack;

import java.util.Stack;

public class TP_2_LC_155_MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public TP_2_LC_155_MinStack() {
        stack=new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty()){
            minStack.push(value);
        }else {
            if (value<=minStack.peek()){
                minStack.push(value);
            }
        }


    }


    public void pop() {
        if (stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}

