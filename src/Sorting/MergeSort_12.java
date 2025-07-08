package src.Sorting;

import java.util.Arrays;

public class MergeSort_12 {
    public static void main(String[] args) {
        int[] arr={8,3,4,12,5,6};
        int s=0;
        int e=arr.length-1;

        mergeSort(arr,s,e);
        System.out.println(Arrays.toString(arr));

    }

    static void mergeSort(int[] arr,int s, int e){
        int m=s+(e-s)/2;
        if (s==e){
            return;
        }
        mergeSort(arr,0,m);
        mergeSort(arr,m+1,arr.length-1);
        merge(arr,s,e,m);
    }

    static void merge(int[] arr, int s, int e, int m){
        int i=0;
        int j=m+1;
        int k=0;
        while(i<m && j<e){
            if (arr[i]<arr[j]){
                arr[k++]=arr[i++];
            }else {
                arr[k++]=arr[j++];
            }
        }

        while(i<m){
            arr[k++]=arr[i++];
        }
        while(j<arr.length){
            arr[k++]=arr[j++];
        }
    }



}
