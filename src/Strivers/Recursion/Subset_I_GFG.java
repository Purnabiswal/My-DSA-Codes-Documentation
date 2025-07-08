package src.Strivers.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

class Subset_I_GFG {
    public static void main(String[] args) {
        int[] arr={1, 2, 1};
        System.out.println(subset(0,arr));
    }
//    public ArrayList<Integer> subsetSums(int[] arr) {
//        return subset(arr,0);
//    }


    static ArrayList<Integer> subset(int p, int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        if(arr.length==0){
            list.add(p);
            return list;
        }

        list.addAll(subset(p+arr[0], Arrays.copyOfRange(arr,1,arr.length)));
        list.addAll(subset(p, Arrays.copyOfRange(arr,1,arr.length)));
        return list;
    }
}