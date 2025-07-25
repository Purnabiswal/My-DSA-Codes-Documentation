package src.StackAndQueue_12.MyImplementation;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    int ptr=-1;
    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size) {
        this.data=new int[size];
    }

    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack is full!1");
            return false;
        }
        ptr++;
        data[ptr]=item;
        return true;
    }

    public int pop() throws StackException {
        if (isEmpty()){
            throw new StackException("Cannot pop from empty stack!!");
        }
//        int removed=data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }

    public int peak() throws StackException{
        if (isEmpty()){
            throw new StackException("Cannot peak from empty stack!!");
        }
        return data[ptr];
    }

    public void display(){
        for (int i = 0; i < ptr; i++) {
            System.out.print(data[i]+" ");
        }
    }

    public boolean isFull() {
        return ptr == data.length-1; //ptr is at last index.
    }

    private boolean isEmpty() {
        return ptr==-1;
    }


}
