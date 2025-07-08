package src.Sorting.SortingInRecursion;

import java.util.Arrays;

//wrong solution
//In place solution
public class MergeSortInPlace_13 {
    public static void main(String[] args) {
        MergeSortInPlace_13 ob=new MergeSortInPlace_13();


        int[] arr={8,3,4,12,5,6};
        ob.mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    void mergeSort(int[] arr, int s, int e){
        if (s>=e){
            return;
        }
        int m = s + (e - s) / 2;
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);
        merge(arr,s,m,e);
    }

    void merge(int[] arr, int s, int m, int e){
        int[] temp=new int[e-s+1];
//        for (int i = 0; i < e-s+1; i++) {
//            temp[i]=arr[s+i];
//        }
        temp=Arrays.copyOfRange(arr,s,e+1);  //Arrays.copyOfRange is exclusive, it means the last value of range is included. That's why we did e+1 here.

        int i=0;
        int j=m-s+1;
        int k=s;
        while(i<=m-s && j<=e-s){
            if (temp[i]<temp[j]){
                arr[k++]=temp[i++];
            }else {
                arr[k++]=temp[j++];
            }
        }
        while (i<=m-s){
            arr[k++]=temp[i++];
        }
        while (j<e-s){
            arr[k++]=temp[j++];
        }
    }
}
