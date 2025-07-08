package src.Maths8;

import java.util.Arrays;

//You can use this method to find the no. repeated once and all the no.s that are repeated 2,4,6,8... times (or simply even times)
public class secondQuestion_2 {
    public static void main(String[] args) {
        //No. are appearing twice
        int[] arr={2,3,4,1,2,1,3,6,4};
        //System.out.println(2^3^4^1^2^1^3^6^6^4^5); //output=5
        System.out.println(nonRepeatedNumber2(arr));
    }

    static int nonRepeatedNumber(int[] nums){

        int ans=nums[0];
        for (int i = 1; i < nums.length;i++) {
            ans=ans^nums[i];
        }

        return ans;
    }

    //Second way with enhanced for loop
    static int nonRepeatedNumber2(int[] nums){

        int ans=0;
        for (int element:nums) {
            ans=ans^element;
        }

        return ans;
    }
}
