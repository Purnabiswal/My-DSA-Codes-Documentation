package src.Heaps_15;

import java.util.ArrayList;

//0-indexed
public class Heap<T extends Comparable<T>> {

    //parent(i)=(i-1)/2
    //left(i)=(2*i)+1
    //right(i)=(2*i)+2
    private ArrayList<T> list;

    public Heap(){
        list=new ArrayList<>();
    }
    public Heap(ArrayList<T> newList){
        this.list=newList;
    }

    private void swap(int i, int j){
        T temp=list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    //for 0-indexed
    private int parent(int index){
        return (index - 1) / 2;
    }
    private int left(int index){
        return 2 * index + 1;
    }
    private int right(int index){
        return 2 * index + 2;
    }



    //0-indexed
    //for min heap
    //TC: O(log N)
    public void insert(T value){
        list.add(value);
        //up-heap
        upheap(list.size()-1);
    }
    //put the element at the correct index (upward checks only)
    private void upheap(int index){
        if (index==0){
            return;
        }
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p))<0){
            //swap
            swap(index, p);
            upheap(p);
        }
    }
    //TC: O(log N)
    public T remove() throws Exception{
        if (list.isEmpty()){
            throw new Exception("Can't remove from empty heap!");
        }
        T removed=list.getFirst();
        T last=list.removeLast();
        if (!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }
        return removed;
    }
    //put the element at the correct index (downward checks only)
    private void downheap(int index){
        int min=index;
        int left= left(index);
        int right= right(index);
        if (left<list.size() && list.get(min).compareTo(list.get(left))>0){
            min=left;
        }
        if (right<list.size() && list.get(min).compareTo(list.get(right))>0){
            min=right;
        }
        if (min!=index){
            swap(index,min);
            downheap(min);
        }

    }

    public ArrayList<T> heapsort() throws Exception{
        ArrayList<T> data=new ArrayList<>();
        while (!list.isEmpty()){
            data.add(remove());
        }
        return data;
    }

//    Creating a min heap from an unsorted array
    public ArrayList<T> createMaxHeap(ArrayList<T> myList){
        Heap<T> ob=new Heap<>(myList);
        for (int i = 0; i < myList.size() / 2; i++) {
            ob.downheap(i);
        }
        return myList;
    }
}
