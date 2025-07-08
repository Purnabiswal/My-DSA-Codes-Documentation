package src.StackAndQueue_12.MyImplementation;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        CustomQueue queue = new CustomQueue(5);
//
//        queue.insert(45);
//        queue.insert(64);
//        queue.insert(34);
//        queue.insert(26);
//        queue.insert(75);
//
//        queue.display();
//
//        queue.remove();
//        queue.remove();
//        queue.remove();
//        queue.remove();
//        queue.remove();
//
//        queue.display();


//        CircularQueue circularQueue = new CircularQueue(5);
//
//        circularQueue.insert(3);
//        circularQueue.insert(6);
//        circularQueue.insert(34);
//        circularQueue.insert(95);
//        circularQueue.insert(8);
//
//        circularQueue.display();
//
//        System.out.println(circularQueue.remove());
//        circularQueue.insert(133);
//
//        circularQueue.display();
//
//        System.out.println(circularQueue.remove());
//        circularQueue.insert(99);
//
//        circularQueue.display();


        DynamicCircularQueue circularQueue = new DynamicCircularQueue(5);

        circularQueue.insert(3);
        circularQueue.insert(6);
        circularQueue.insert(34);
        circularQueue.insert(95);
        circularQueue.insert(8);
        circularQueue.insert(83);
        circularQueue.insert(83);

        circularQueue.display();

        System.out.println(circularQueue.remove());

        circularQueue.display();
    }
}
