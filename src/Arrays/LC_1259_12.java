package src.Arrays;

public class LC_1259_12 {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
        //LC=leetcode

        int[] nums = {0,-22,12,345,2,6,-7896,32,42};
        int ans=findNumbers(nums);
        System.out.println(ans);

    }

    static int findNumbers(int[] nums) {
        int count=0;



        for(int element:nums){
            if(element<0){
                element*=-1;
            }
            if(even(element)){
                count++;
            }
        }
        return count;
    }


    static boolean even(int num){
        int count=0;

        if(num==0){
            return false;
        }
        //logic for digit count
        while(num>0){
            count++;
            num=num/10;
        }
//        another way for digit count
//        if(num>0){
//            count=(int)(Math.log10(num))+1;
//        }

        return count%2==0;
    }
}
