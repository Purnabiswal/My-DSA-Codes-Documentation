package src.T_18_DP.Day_4;

import java.util.Arrays;

public class DP_24_RodCutting {
    public static void main(String[] args) {
//        int[] price={2, 5, 7 ,8, 10};
        int[] price={25, 79, 59, 63, 65, 6, 46, 82 };
        System.out.println(cutRod(price, price.length));
        System.out.println(cutRod2(price, price.length));
        System.out.println(cutRod3(price, price.length));
        System.out.println(cutRod4(price, price.length));
    }



    //Recursion
    //TC: O(exponential)
    //SC: O(Rod length n)
    public static int cutRod(int price[], int n) {
        return f(price.length-1, n, price);
    }
    static int f(int i, int n, int[] pr){
        if (n==0) return 0;
        if (i==0) return n*pr[0];

        int pick = Integer.MIN_VALUE;
        if (n>=i+1){
            pick=pr[i]+f(i, n-(i+1), pr);
        }

        int non_pick=f(i-1,n,pr);
        return Math.max(pick, non_pick);
    }



    //Memoization
    //TC: O(N*N)
    //SC: O(N*N) + O(target n)
    public static int cutRod2(int price[], int n) {
        int[][] dp=new int[n][n+1];
        for (int[] e:dp){
            Arrays.fill(e, -1);
        }
        return f2(price.length-1, n, price, dp);
    }

    static int f2(int i, int n, int[] pr, int[][] dp){
        if (n==0) return 0;
        if (i==0) return n*pr[0];

        if (dp[i][n]!=-1){
            return dp[i][n];
        }
        int pick = Integer.MIN_VALUE;
        if (n>=i+1){
            pick=pr[i]+f2(i, n-(i+1), pr, dp); //rod length = i+1
        }

        int non_pick=f2(i-1,n,pr, dp);
        return dp[i][n] = Math.max(pick, non_pick);
    }



    //Tabulation
    //TC: O(N*N)
    //SC: O(N*N)
    public static int cutRod3(int price[], int n) {
        int[][] dp=new int[n][n+1];
        for (int i = 0; i < n+1; i++) {
            dp[0][i] = i*price[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n+1; j++) {
                int non_pick=dp[i-1][j];
                int pick=Integer.MIN_VALUE;
                int rod_length=i+1;
                if (j>=rod_length){
                    pick=price[i]+dp[i][j-rod_length];
                }
                dp[i][j]=Math.max(pick, non_pick);
            }
        }

        return dp[n-1][n];
    }

    //Tabulation
    //TC: O(N*N)
    //SC: O(N+1)
    public static int cutRod4(int price[], int n) {
        int[] prev=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            prev[i] = i*price[0];
        }

        for (int i = 1; i < n; i++) {
            int[] temp=new int[n+1];
            for (int j = 1; j < n+1; j++) {
                int non_pick=prev[j];
                int pick=Integer.MIN_VALUE;
                int rod_length=i+1;
                if (j>=rod_length){
                    pick=price[i]+temp[j-rod_length];
                }
                temp[j]=Math.max(pick, non_pick);
            }
            prev=temp;
        }

        return prev[n];
    }


    //IMPORTANT
    //Tabulation
    //More optimized one
    //TC: O(N*N)
    //SC: O(N+1)
    public static int cutRod5(int price[], int n) {
        int[] prev=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            prev[i] = i*price[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n+1; j++) {
                int non_pick=prev[j];
                int pick=Integer.MIN_VALUE;
                int rod_length=i+1;
                if (j>=rod_length){
                    pick=price[i]+prev[j-rod_length];
                }
                prev[j]=Math.max(pick, non_pick);
            }
        }

        return prev[n];
    }

}

