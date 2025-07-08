package src.Sorting;

import java.util.Arrays;

//https://leetcode.com/problems/set-mismatch/description/
//Set mismatch
public class LC_645_37 {
    public static void main(String[] args) {
        int[] arr={8,7,3,5,3,6,1,4};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    //cyclic sort
    static int[] findErrorNums(int[] nums){
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1; //correct index= value-1;
            if(nums[i]!=nums[correct]){
                int t=nums[i];
                nums[i]=nums[correct];
                nums[correct]=t;
            }else {
                i++;
            }
        }

        for(int j=0;j<nums.length;j++){
            if(j!=nums[j]-1){
                return new int[]{nums[j],j+1};
            }
        }
        return new int[]{-1,-1};
    }
}
