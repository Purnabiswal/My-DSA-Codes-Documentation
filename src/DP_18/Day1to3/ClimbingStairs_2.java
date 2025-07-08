package src.DP_18.Day1to3;

import java.util.Arrays;

public class ClimbingStairs_2 {
    public static void main(String[] args) {

    }

    //70. Climbing Stairs. Easy
    //memoization
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairs(n, dp);
    }

    public int climbStairs(int n, int[] dp) {
        if (n<=0){
            return n+1;
        }
        if (dp[n]!=-1){
            return dp[n];
        }

        return dp[n]=climbStairs(n-1, dp)+climbStairs(n-2, dp);
    }

    //70. Climbing Stairs. Easy
    //tabulation: bottom-up
    public int climbStairs2(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //70. Climbing Stairs. Easy
    //tabulation: bottom-up
    //Efficient
    public int climbStairs3(int n) {
        int prev=1;
        int prev2=1;
        for (int i = 2; i <= n; i++) {
            int curi=prev+prev2;
            prev2=prev;
            prev=curi;
        }
        return prev;
    }
}
