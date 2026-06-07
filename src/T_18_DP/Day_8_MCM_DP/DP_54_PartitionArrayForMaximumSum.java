package src.T_18_DP.Day_8_MCM_DP;

import java.util.Arrays;

//LC_1043
//https://www.naukri.com/code360/problems/partition-array-for-maximum-sum_3755255
public class DP_54_PartitionArrayForMaximumSum {
    public static void main(String[] args) {

        int k=3;
        int[] arr={1,15,7,9,2,5,10};

        System.out.println(maxSumAfterPartitioning(arr, k));
        System.out.println(maxSumAfterPartitioning2(arr, k));
        System.out.println(maxSumAfterPartitioning3(arr, k));


//        System.out.println(cost(2, arr.length-1, arr));

    }


    //Universal max sum
    private static int cost(int i, int j, int[] a) {
        int max=a[i];
//        System.out.println(i+" "+ j);
        for (int k = i; k <= j; k++) {
            if (a[k]>max){
                max=a[k];
            }
        }
        return max*(j-i+1);
    }


    //Recursion
    static public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        return f(0, k, n, arr);
    }
    static public int f(int i, int k, int n, int[] a){
        if (i>=n) return 0;
        if (i==n-1) return a[i];

        int max=Integer.MIN_VALUE;
        int count=0;
        for (int j = i; j < n && count<k; j++) {
            count++;
            int cost=cost(i, j, a)+f(j+1, k, n, a);
            max=Math.max(max, cost);
        }

        return max;
    }





    //static takes less ms to run on leetcode: try running this below code on leetcode with and without static
    //Memo
    //TC: O(n*k)
    //SC: O(n) + O(n) stack
    static public int maxSumAfterPartitioning2(int[] arr, int k) {
        int n=arr.length;

        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        return f2(0, k, n, arr, dp);
    }
    static public int f2(int i, int k, int n, int[] a,int[] dp){
        if (i==n) return 0;
        if (i==n-1) return a[i];

        if (dp[i]!=-1){
            return dp[i];
        }
        int max=Integer.MIN_VALUE;
        int maxVal=Integer.MIN_VALUE;
        int len=0;
        int count=0;
        for (int j = i; j < n && count<k; j++) {
            count++;
            len++;
            maxVal=Math.max(maxVal, a[j]);
            int cost=(maxVal*len)+f2(j+1, k, n, a, dp);
            max=Math.max(max, cost);
        }

        return dp[i]=max;
    }

    //Memo
    //TC: O(n*k)
    //SC: O(n)
    static public int maxSumAfterPartitioning3(int[] a, int k) {
        int n=a.length;
        int[] dp=new int[n+1];

        for (int i = n-1; i >= 0; i--) {
            int max=Integer.MIN_VALUE;
            int count=0;
            int maxVal=Integer.MIN_VALUE;
            int len=0;
            for (int j = i; j < n && count<k; j++) {
                count++;
                len++;
                maxVal=Math.max(maxVal, a[j]);
                int cost=(maxVal*len)+dp[j+1];
                max=Math.max(max, cost);
            }

            dp[i]=max;
        }

        return dp[0];
    }



}
