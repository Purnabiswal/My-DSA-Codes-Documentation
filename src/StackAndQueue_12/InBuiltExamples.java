package src.StackAndQueue_12;

import java.util.*;

public class InBuiltExamples {
    public static void main(String[] args) {
        //FILO, LIFO
//        Stack<Integer> stack = new Stack<>();
//        stack.push(34);
//        stack.push(68);
//        stack.push(25);
//        stack.push(52);
//        stack.push(75);
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());


        //FIFO, LILO
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(3);
//        queue.add(54);
//        queue.add(48);
//        queue.add(34);
//        queue.add(94);
//
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue);




        //Deque
        //Doubly ended queue, insertion & removal can happen from both sides
        //Uses: In trees
        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(89);
        deque.add(54);
        deque.add(27);
        deque.add(64);
        deque.add(27);

        System.out.println(deque);
//        deque.addFirst(23); //adds the element at first.
//        System.out.println("Offer: "+deque.offerFirst(54));
//        System.out.println(deque.removeFirst()); //removes the first element
//        System.out.println(deque.removeLast());
        System.out.println(deque);


    }
}
