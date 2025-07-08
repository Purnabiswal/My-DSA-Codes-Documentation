package src.StackAndQueue_12.MyImplementation;

public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE=10;
    int end=0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size){
        data=new int[size];
    }

    public boolean insert(int item){
        if (isFull()){
            System.out.println("Queue is full!!");
            return false;
        }
        data[end++]=item;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()){
            throw new Exception("Cannot remove from a empty queue!!");
        }
        int removed=data[0];
        //shift the elements to left
        for (int i = 1; i < end; i++) {
            data[i-1]=data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }


    public boolean isFull(){
        return end == data.length; //As we are starting end from zero, end will stay just after the data
    }
    private boolean isEmpty(){
        return end==0;
    }
    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

}
