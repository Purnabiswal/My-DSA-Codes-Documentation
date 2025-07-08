package src.Arrays;

import java.util.Arrays;

public class Swap7 {
    public static void main(String[] args) {

        int[] arr={1,25,34,85,34};


        System.out.println("Before: "+Arrays.toString(arr));
        swap(arr,1,3);
        System.out.println("After: "+Arrays.toString(arr));
        reverseTheArray(arr);
        System.out.println("Reversed array: "+Arrays.toString(arr));
    }


    static void reverseTheArray(int[] arr){
        int start=0;
        int end=arr.length-1;

        while (start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
//By for loop
//        for (;start<end;start++){
//            swap(arr,start,end);
//            end--;
//        }
    }


    static void swap(int[] arr,int index1,int index2){
       int temp=arr[index1];
       arr[index1]=arr[index2];
       arr[index2]=temp;
    }
}
