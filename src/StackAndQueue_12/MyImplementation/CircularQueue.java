package src.StackAndQueue_12.MyImplementation;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    protected int front=0;
    protected int end=0;
    private int size=0;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size){
        data = new int[size];
    }
    public boolean isFull(){
        return size == data.length;
    }
    private boolean isEmpty(){
        return size==0;
    }
    public void display(){
        if (isEmpty()){
            System.out.println("Empty");
            return;
        }
        int i=front;
        do {
            System.out.print(data[i++] + " -> ");
            i = i % data.length;
        }while (i!=end);
        System.out.println("END");
    }


    public boolean insert(int item){
        if (isFull()){
            System.out.println("Queue is full!!");
            return false;
        }
        data[end++]=item;
        end=end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()){
            throw new Exception("Cannot remove from a empty queue!!");
        }
        int removed=data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()){
            throw new Exception("Cannot remove from a empty queue!!");
        }
        return data[front];
    }

}
