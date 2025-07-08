package src.AdvanceSortingAlgorithms_17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//only works for small numbers
//but very fast
//stable sort
public class CountSort {
    public static void main(String[] args) {
        int[] arr= {6,5,3,4,9,7,2,5,3,5,4,6,7};
        countSort(arr);
        System.out.println();
        countSortHash(arr);

    }

    //countSort using HashMap
    public static void countSortHash(int[] arr){
        if (arr==null || arr.length<=1){
            return;
        }

        //find max min
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        //make a frequency HashMap
        Map<Integer, Integer> countMap=new HashMap<>();
        for (int e:arr) {
            countMap.put(e, countMap.getOrDefault(e, 0)+1);
        }

        //put back to an original array
        int index=0;
        for (int i=min; i <= max;i++){
            int count=countMap.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                arr[index++]=i;
            }
        }

        //print
        for (int e:arr){
            System.out.print(e+" ");
        }
    }


    //This countSort is not stable but countSort can be stable
    public static void countSort(int[] arr){
        if (arr==null || arr.length<=1){
            return;
        }

        //find max first
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        //make a frequency array
        int[] countArray=new int[max+1];
        for (int e:arr) {
            countArray[e]++;
        }

        //put back to an original array
        int index=0;
        for (int i=0; i < countArray.length;i++){
            while (countArray[i]>0){
                arr[index]=i;
                countArray[i]--;
                index++;
            }
        }

        //print
        for (int e:arr){
            System.out.print(e+" ");
        }
    }


}
