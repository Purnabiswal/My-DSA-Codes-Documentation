package src.Sorting;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
//microsoft & amazon
public class LC_442_36 {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }

    static List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> duplicates=new ArrayList<>();
        int i=0;
        while(i< nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                int t=nums[i];
                nums[i]=nums[correct];
                nums[correct]=t;
            }else {
                i++;
            }
        }

        for(int j=0;j<nums.length;j++){
            if (j!=nums[j]-1){
                duplicates.add(nums[j]);
            }
        }
        return duplicates;
    }
}
