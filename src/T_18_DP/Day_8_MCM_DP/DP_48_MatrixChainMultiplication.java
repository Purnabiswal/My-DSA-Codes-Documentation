package src.T_18_DP.Day_8_MCM_DP;

import java.util.Arrays;

//https://www.naukri.com/code360/problems/matrix-chain-multiplication_975344
public class DP_48_MatrixChainMultiplication {
    public static void main(String[] args) {
//        int[] a={10,20,30,40,50};
//        int[] a={4,5,3,2};
        int[] a={40, 29 ,32 ,33 ,44 ,33, 20, 42,45 ,26, 40, 30, 34, 23, 34 ,42, 35 ,40, 25, 32 };
        System.out.println(mcm(a, a.length));
        System.out.println(mcm2(a, a.length));


    }

    //Recursion
    //TC: exponential
    public static int mcm(int[] arr , int n) {
        return f(1, n-1, arr);
    }
    public static int f(int i, int j, int[] a){
        if (i==j) return 0;

        int min=(int) 1e9;
        int steps;
        for (int k = i; k < j; k++) {          // Or (int k = i; k <= j-1; k++)
            steps=a[i-1]*a[k]*a[j]+f(i, k, a)+f(k+1, j, a);
            min=Math.min(min, steps);
        }
        return min;
    }




    //Memo
    //TC: O(n*n*n) nearly O(n^3)
    //SC: O(n*n) + O(n)
    public static int mcm2(int[] arr , int n) {
        int[][] dp=new int[n][n];
        for (int[] e:dp){
            Arrays.fill(e, -1);
        }
        return f2(1, n-1, arr, dp);
    }
    public static int f2(int i, int j, int[] a, int[][] dp){
        if (i==j) return 0;

        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=(int) 1e9;
        int steps;
        for (int k = i; k < j; k++) {          // Or (int k = i; k <= j-1; k++)
            steps=a[i-1]*a[k]*a[j]+f2(i, k, a, dp)+f2(k+1, j, a, dp);
            min=Math.min(min, steps);
        }
        return dp[i][j]=min;
    }


}
