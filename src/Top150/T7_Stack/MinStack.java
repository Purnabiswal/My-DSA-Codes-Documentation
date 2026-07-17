package src.Top150.T7_Stack;

import java.util.Stack;

class MinStack {

    int[] arr;
    int top;
    int size;
    Stack<Integer> minStack;

    public MinStack() {
        arr=new int[10];
        minStack = new Stack<>();
        top=-1;
        size=0;
    }

    public void push(int value) {
        if (size==arr.length){
            int[] temp=new int[arr.length*2];
            for (int i = 0; i < arr.length; i++) {
                temp[i]=arr[i];
            }
            arr=temp;
        }
        arr[top+1]=value;
        minStack.push(Math.min(value,(minStack.isEmpty())?Integer.MAX_VALUE:minStack.peek()));
        top++;
        size++;
    }


    public void pop() {
        if (size>0) top--;
        size--;
        minStack.pop();
    }

    public int top() {
        return arr[top];
    }

    public int getMin() {
        return minStack.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */