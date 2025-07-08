                package src.Sorting;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
//Google
public class LC_448_34 {
    public static void main(String[] args) {
        int[] arr={1,1,2,2};

        System.out.println(findDisappearedNumbers(arr));
    }

    static List<Integer> findDisappearedNumbers(int[] arr) {
        ArrayList<Integer> missing=new ArrayList<>(1);
        int i=0;

        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){ //this condition should work for duplicate values also
                int t=arr[i];
                arr[i]=arr[correct];
                arr[correct]=t;
            }else {
                i++;
            }
        }

        for (int j=0;j<arr.length;j++){
            if(j!=arr[j]-1){
                missing.add(j+1);
            }
        }
        return missing;
    }
}
