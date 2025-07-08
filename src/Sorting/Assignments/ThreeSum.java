package src.Sorting.Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//wrong
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4,-2,-3,3,0,4}; //-1,0,1,2,-1,-4,-2,-3,3,0,4
        System.out.println(threeSum(arr));
    }

    static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> arrayList=new ArrayList<>();

        //insertionSort(arr);
        Arrays.sort(arr);

        int k=0;
        int i=0;
        int sum;
        while(i< arr.length-2){
            if (k>= arr.length-2){
                i++;
                k=i;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                i++;
                k=i;
                continue;
            }
            k++;
            if (k >i+1 && arr[k] == arr[k - 1]) {
                continue;
            }
            for (int j=k+1;j<arr.length;j++){
                if (j > k+1 && arr[j] == arr[j - 1]) {

                    continue;
                }
                sum=arr[i]+arr[k]+arr[j];
                if (sum==0){
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[k]);
                    list.add(arr[j]);
                    arrayList.add(list);
                    //arrayList.add(Arrays.asList(arr[i],arr[k],arr[j]));
                } else if (sum>0) {
                    break;
                }
            }

        }
        return arrayList;
    }

    static void insertionSort(int[] arr){
        for (int i=0;i< arr.length-1;i++){ // "i" will go till n-1 that is: i<=arr.length-2 or i< arr.length-1
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int t=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=t;
                }else { // if j>j-1 then break, because the previous array is already sorted
                    break;
                }
            }
        }
    }

}
