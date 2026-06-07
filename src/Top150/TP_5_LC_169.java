package src.Top150;

import java.util.Arrays;

public class TP_5_LC_169 {
    public static void main(String[] args) {
        int[] arr={0,0,0,1,2,3,3,3,3};
        System.out.println(majorityElement(arr));
    }
    static public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        // int count=0;
        // int m=nums[0];
        // for(int i=0;i<n;i++){
        //     if(count>n/2){
        //         return m;
        //     }
        //     if(m != nums[i]){
        //         m=nums[i];
        //         count=0;
        //     }
        //     count++;
        // }
        // return m;
        int x=n/2;
        return nums[x];
    }
}
