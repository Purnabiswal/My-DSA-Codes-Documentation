package src.DP_18.Day1to3;

import java.util.Arrays;

public class Fibonacci_1 {
    public static void main(String[] args) {
        System.out.println(fibo(2888));
        System.out.println(fibo2(2888));
        System.out.println(fibo3(2888));
    }

    //Memoization: top-down approach
    //recursive approach is top-down
    //TC: O(N)
    //SC: O(N) + O(N)
    static int fibo(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return fibo(n, dp);
    }
    static int fibo(int n, int[] dp){
        //base case
        if (n<=1){
            return n;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        return dp[n] = fibo(n-1,dp)+fibo(n-2,dp);
    }

    //Tabulation: bottom-up
    //TC: O(N)
    //SC: O(N)
    static int fibo2(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //Tabulation: bottom-up
    //TC: O(N)
    //SC: O(2)
    static int fibo3(int n){
        if (n == 0) return 0;
        int prev2=0; //2nd previous
        int prev=1;  //previous
        for (int i = 2; i <= n; i++) {
            int curi=prev2+prev;
            prev2=prev;
            prev=curi;
        }
        return prev;
    }

/*    Steps to convert Recursive Solution to Tabulation one.
        Declare a dp[] array of size n+1.
        First initialize the base condition values, i.e i=0 and i=1 of the dp array as 0 and 1 respectively.
        Set an iterative loop that traverses the array( from index 2 to n) and for every index set its value as dp[i-1] + dp[i-2].
*/

}
