package src.StackAndQueue_12.MyImplementation;

public class DynamicCircularQueue extends CircularQueue {
    public DynamicCircularQueue(){
        super();
    }
    public DynamicCircularQueue(int size){
        super(size);
    }

    //way-1
//    @Override
//    public boolean insert(int item) {
//        if (isFull()){
//            int[] temp=new int[data.length*2];
//            end=data.length;
//            for (int i = 0; i < data.length; i++) {
//                temp[i]=data[i];
//            }
//            data=temp;
//        }
//        return super.insert(item);
//    }

    //way-2: Better way
    @Override
    public boolean insert(int item) {
        if (isFull()){
            int[] temp=new int[data.length*2];
            for (int i = 0; i < data.length; i++) {
                temp[i]=data[(front+i) % data.length];
            }
            front=0;
            end= data.length;
            data=temp;
        }
        return super.insert(item);
    }
}
