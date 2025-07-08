package src.DP_18.Day1to3;

import java.util.Arrays;

//frog can jump k steps
public class FrogJumpKjump_4 {
    public static void main(String[] args) {
        int[] heights = {7, 5, 1,3,6,8,5,9};
        int k=2;
        System.out.println(frogJump(heights, k));
        System.out.println(frogJump2(heights, k));
    }


    //Memoization:
    //Instead of re-calculating the same thing again and again, we are using dp[] to store and retrieve next time
    //TC: O(N*K)
    //SC: O(N)+O(N)
    static public int frogJump(int[] heights, int k) {
        int n = heights.length-1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(heights, n, k, dp);
    }
    static public int f(int[] heights, int n, int k, int[] dp) {
        if (n==0){
            return 0;
        }
        if (dp[n]!=-1){
            return dp[n];
        }

        int ans=Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n-i>=0){
                int jump=f(heights, n-i, k, dp)+Math.abs(heights[n]-heights[n-i]);
                ans=Math.min(ans, jump);
            }
        }
        return dp[n]=ans;
    }

    //Tabulation:
    //TC: O(N*K)
    //SC: O(N)
    static public int frogJump2(int[] heights, int k) {
        int n = heights.length;
        int[] dp=new int[n];
        dp[0]=0;
        for (int i = 1; i < n; i++) {
            int minEnergy=Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i-j>=0) {
                    int jumpCost=dp[i-j]+Math.abs(heights[i]-heights[i-j]);
                    minEnergy=Math.min(minEnergy, jumpCost);
                }
            }
            dp[i]=minEnergy;
        }
        return dp[n-1];
    }

    //Tabulation:
    //Space optimization
    //TC: O(N*K)
    //SC: O(K) but if k==n, it's again SC of O(N)
    static public int frogJump3(int[] heights, int k) {
        //can be done by taking arr of size k.
        return 0;
    }

}
