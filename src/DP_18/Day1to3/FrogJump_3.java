package src.DP_18.Day1to3;

import java.util.Arrays;

public class FrogJump_3 {
    public static void main(String[] args) {
        int[] heights = {7, 5, 1,3,6,8,5,9};
        System.out.println(frogJump(heights));
        System.out.println(frogJump2(heights));
    }


    //Memoization:
    //Instead of re-calculating the same thing again and again, we are using dp[] to store and retrieve next time
    static public int frogJump(int[] heights) {
        int n = heights.length-1;
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return frogJump(heights, n, dp);
    }
    static public int frogJump(int[] heights, int n, int[] dp) {
        if (n==0){
            return 0;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        int jumpOne=Math.abs(heights[n]-heights[n-1])+frogJump(heights, n-1, dp);
        int jumpTwo=Integer.MAX_VALUE;
        if (n>1){
            jumpTwo=Math.abs(heights[n]-heights[n-2])+frogJump(heights, n-2, dp);
        }

        return dp[n]=Math.min(jumpOne, jumpTwo);
    }

    //Tabulation:
    static public int frogJump2(int[] heights) {
        int n = heights.length;
        int[] dp=new int[n];
        dp[0]=0;

        for (int i = 1; i < n; i++) {
            int jumpOne=Math.abs(heights[i]-heights[i-1])+dp[i-1];
            int jumpTwo=Integer.MAX_VALUE;
            if (i>1){
                jumpTwo=Math.abs(heights[i]-heights[i-2])+dp[i-2];
            }
            dp[i]=Math.min(jumpOne, jumpTwo);
        }
        return dp[n-1];
    }

    //Tabulation:
    //Space optimization
    static public int frogJump3(int[] heights) {
        int n = heights.length;
        int prev2=0;
        int prev=0;

        for (int i = 1; i < n; i++) {
            int jumpOne=Math.abs(heights[i]-heights[i-1])+prev;
            int jumpTwo=Integer.MAX_VALUE;
            if (i>1){
                jumpTwo=Math.abs(heights[i]-heights[i-2])+prev2;
            }
            int curi=Math.min(jumpOne, jumpTwo);
            prev2=prev;
            prev=curi;
        }
        return prev;
    }

}
