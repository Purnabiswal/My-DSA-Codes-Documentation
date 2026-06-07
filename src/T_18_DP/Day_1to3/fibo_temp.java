package src.T_18_DP.Day_1to3;

import java.util.Arrays;

public class fibo_temp {
    public static void main(String[] args) {
        System.out.println(f3(1000));
        System.out.println(f2(1000));
        System.out.println(f1(1000));
//        System.out.println(f(388));
    }



    //rec
    static int f(int n){
        if(n==0 || n==1){
            return n;
        }

        return f(n-1)+f(n-2);
    }


    //memo
    static int f1(int n){
        int[] dp=new int[n+1];

        Arrays.fill(dp, -1);

        return helper(n,dp);
    }

    static int helper(int n, int[] dp){
        if (n==0 || n==1){
            return n;
        }

        if (dp[n]!=-1){
            return dp[n];
        }

        return dp[n]=helper(n-1, dp)+helper(n-2, dp);
    }


    //tabulation
    static int f2(int n){
        int[] dp=new int[n+1];
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    //tabulation
    static int f3(int n){
        if(n==0) return 0;
        int prev=1;
        int prev2=0;
        for (int i=2;i<=n;i++){
            int curi=prev+prev2;
            prev2=prev;
            prev=curi;
        }
        return prev;
    }

}
