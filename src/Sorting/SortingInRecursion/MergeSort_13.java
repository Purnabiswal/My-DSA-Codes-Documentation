package src.Sorting.SortingInRecursion;

import org.w3c.dom.ranges.Range;

import java.util.Arrays;

public class MergeSort_13 {
    public static void main(String[] args) {
        MergeSort_13 ob=new MergeSort_13();
//        int[] arr1={3,4,8};
//        int[] arr2={5,6,12};

        int[] arr={9,8,7,6,5,4,3,2,1};
        int[] x=ob.mergeSort(arr);
        System.out.println(Arrays.toString(x));
        //System.out.println(Arrays.toString(ob.merge(arr1,arr2)));
    }

    int[] mergeSort(int[] arr){
        if (arr.length<=1 ){
            return arr;
        }
        int m = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,m));  //Arrays.copyOfRange is exclusive, it means the value of m is ignored
        int[] right = mergeSort(Arrays.copyOfRange(arr,m,arr.length));
        return merge(left, right);
    }

    int[] merge(int[] arr1,int[] arr2){
        int size=arr1.length+arr2.length;
        int[] arr=new int[size];
        int i=0;
        int j=0;
        int k=0;
        while(i<arr1.length && j<arr2.length){
            if (arr1[i]<arr2[j]){
                arr[k++]=arr1[i++];
            }else {
                arr[k++]=arr2[j++];
            }
        }
        //It may be possible that one of the array is incomplete
        //copy the remaining elements
        while (i<arr1.length){
            arr[k++]=arr1[i++];
        }
        while (j<arr2.length){
            arr[k++]=arr2[j++];
        }
        return arr;
    }
}
