package src.DP_18.Day1to3;

import java.util.Arrays;

//Pick it or not pick it approach (like subset/subsequence problems)
public class HouseRobberPickNotPickWay_6 {
    public static void main(String[] args) {

        int[] nums={1,2,3,1,6,8,7,6,6,6,9};
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
        return rob(nums, n, dp);
    }
    static public int rob(int[] nums, int n, int[] dp) {
        if (n==0){
            return nums[0];
        }
        if (n<0){
            return 0;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        int pick=nums[n]+rob(nums, n-2, dp);
        int notPick=rob(nums, n-1, dp);
        return Math.max(pick, notPick);
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
        dp[1]=Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick=nums[i]+dp[i-2];
            int notPick=dp[i-1];
            dp[i]=Math.max(pick, notPick);
        }

        return dp[n-1];
    }

    //Tabulation
    //TC:O(N)
    //SC:O(1)
    //Space Efficient
    static public int rob3(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick=nums[i]+prev2;
            int notPick=prev;
            int curi = Math.max(pick, notPick);
            prev2=prev;
            prev=curi;
        }

        return prev;
    }




}
