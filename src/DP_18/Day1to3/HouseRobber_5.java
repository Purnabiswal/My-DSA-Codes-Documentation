package src.DP_18.Day1to3;

import java.util.Arrays;

//Fibonacci approach
//198. House Robber
public class HouseRobber_5 {
    public static void main(String[] args) {

        int[] nums={1,2,3,1};
        System.out.println(rob(nums));
        System.out.println(rob2(nums));
        System.out.println(rob3(nums));
    }


    //Memoization:
    //TC:O(N)
    //SC:O(N)+O(N)
    static public int rob(int[] nums) {
        int n= nums.length-1;
        if(n==0){
            return nums[0];
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return Math.max(rob(nums, n, dp), rob(nums, n-1, dp));
    }
    static public int rob(int[] nums, int n, int[] dp) {
        if (n<=1){
            return nums[n];
        }

        if (dp[n]!=-1){
            return dp[n];
        }

        int left=rob(nums, n-2, dp);
        int right=Integer.MIN_VALUE;
        if (n-3>=0){
            right=rob(nums, n-3, dp);
        }

        return Math.max(left, right)+nums[n];
    }

    //Tabulation
    //TC:O(N)
    //SC:O(N)
    static public int rob2(int[] nums) {
        int n= nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n];

        dp[0]=nums[0];
        dp[1]=nums[1];

        for (int i = 2; i < n; i++) {
            int right=Integer.MIN_VALUE;
            if (i-3>=0){
                right=dp[i-3];
            }
            dp[i]=Math.max(dp[i-2], right)+nums[i];
        }
        for (int i = 3; i < n; i++) {
            int left=dp[i-2];
            int right = dp[i - 3];
            dp[i]=Math.max(left, right)+nums[i];
        }
        return Math.max(dp[n-1], dp[n-2]);
    }

    //Tabulation
    //TC:O(N)
    //SC:O(1)
    //Space Efficient
    //wrong output
    static public int rob3(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int prev3=Integer.MIN_VALUE;
        int prev2=nums[0];
        int prev=nums[1];
        for (int i = 2; i < n; i++) {
            int left=prev2;
            int right=Integer.MIN_VALUE;
            if (i-3>=0){
                right=prev3;
            }
            int curi = Math.max(left, right)+nums[i];
            prev3=prev2;
            prev2=prev;
            prev=curi;
        }
        int ans=prev2;
        prev3=Integer.MIN_VALUE;
        prev2=nums[0];
        prev=nums[1];
        for (int i = 3; i < n; i++) {
            int left = prev2;
            int right = prev3;
            int curi = Math.max(left, right)+nums[i];
            prev3=prev2;
            prev2=prev;
            prev=curi;
        }
        return Math.max(ans, prev);
    }




}
