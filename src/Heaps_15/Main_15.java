package src.Heaps_15;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main_15 {
    public static void main(String[] args) throws Exception {
//        //This is also known as priority queue using heap
//        Heap<Integer> heap=new Heap<>();
//        heap.insert(99);
//        heap.insert(35);
//        heap.insert(89);
//        heap.insert(52);
//        heap.insert(2);
//        heap.insert(12);
//        heap.insert(13242);
//        heap.insert(122);
//
//
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//
//        ArrayList<Integer> list=heap.heapsort();
//        System.out.println(list);
////        System.out.println(heap.heapsort());
//
//
//        //internal priority queue
//        PriorityQueue<Integer> queue=new PriorityQueue<>();
//
//
//        //Priority queue can also be implemented using LinkedList. But in this insert will take O(N) time which is bad where Priority queue using heap will take O(log n) for insert
//
//
//        //Creating a heap from unsorted array
//        int[] arr={4,1,3,2,16,9,10,14,8,7};
//        ArrayList<Integer> arrayList=new ArrayList<>();
//        for (int e:arr){
//            arrayList.add(e);
//        }
//        System.out.println(heap.createMaxHeap(arrayList));
//

        HuffmanCoder coder=new HuffmanCoder("abbccda");
        System.out.println(coder.encode("abbccda"));
        System.out.println(coder.decode("11010110100011"));



    }
}
