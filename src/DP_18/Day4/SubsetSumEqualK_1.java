package src.DP_18.Day4;

//Link:
//Code360: https://www.naukri.com/code360/problems/subset-sum-equal-to-k_1550954

import java.util.Arrays;

public class SubsetSumEqualK_1 {
    public static void main(String[] args) {
        int[] arr = {2,8,2,9,3};


        System.out.println(subsetSumToK(arr.length, 4, arr));
        System.out.println(subsetSumToK2(arr.length, 4, arr));
        System.out.println(subsetSumToK3(arr.length, 4, arr));
        System.out.println(subsetSumToK4(arr.length, 4, arr));
        System.out.println(subsetSumToK5(arr.length, 4, arr));
        System.out.println(subsetSumToK6(arr.length, 4, arr));

    }

    //Recursion
    //TC: O(2^N)
    //SC: O(N)
    public static boolean subsetSumToK(int n, int k, int[] arr){
        // Write your code here.

        return f(n-1,  k, arr);
    }
    public static boolean f(int n, int k, int[] arr){
        if (k==0){
            return true;
        }
        if (k<0 || n<0){
            return false;
        }

        return f(n-1, k-arr[n], arr) || f(n-1, k, arr);
    }


    //Memoization
    //TC: O(N*K)
    //SC: O(N) + O(N*K)
    public static boolean subsetSumToK2(int n, int k, int[] arr){
        // Write your code here.
        int[][] dp = new int[n][k+1];
        for (int[] e : dp){
            Arrays.fill(e, -1);
        }

        return f2(n-1,  k, arr, dp);
    }
    public static boolean f2(int n, int k, int[] arr, int[][] dp){
        if (k==0){
            return true;
        }
        if (k<0 || n<0){
            return false;
        }
        if (dp[n][k]!=-1){
            return dp[n][k] == 0;
        }

        dp[n][k] = (f2(n-1, k-arr[n], arr, dp) || f2(n-1, k, arr, dp))?0:1;
        return dp[n][k]==0;
    }


    //Memoization
    //TC: O(N*K)
    //SC: O(N) + O(N*K)
    //Using Boolean[][] Wrapper Class
    public static boolean subsetSumToK3(int n, int k, int[] arr){
        Boolean[][] dp = new Boolean[n][k+1];
        return f3(n-1,  k, arr, dp);
    }
    public static boolean f3(int n, int k, int[] arr, Boolean[][] dp){
        if (k==0){
            return true;
        }
        if (k<0 || n<0){
            return false;
        }
        if (dp[n][k]!=null){
            return dp[n][k];
        }

        return dp[n][k] = f3(n-1, k-arr[n], arr, dp) || f3(n-1, k, arr, dp);
    }


    //Memoization
    //Special: Striver's code
    //TC: O(N*K)
    //SC: O(N) + O(N*K)
    public static boolean subsetSumToK10(int n, int k, int[] arr){
        Boolean[][] dp = new Boolean[n][k+1];
        return f10(n-1,  k, arr, dp);
    }
    public static boolean f10(int n, int k, int[] arr, Boolean[][] dp){
        if (k==0){
            return true;
        }
        if (n==0){
            return arr[0]==k;
        }
        if (dp[n][k]!=null){
            return dp[n][k];
        }

        boolean nonTake = f10(n-1, k, arr, dp);
        boolean take = false;
        if (!nonTake && k>=arr[n]){
            take = f10(n-1, k-arr[n], arr, dp);
        }

        return dp[n][k] = take || nonTake;
    }


    //Tabulation
    //TC: O(N*K)
    //SC: O(N*K)
    public static boolean subsetSumToK4(int n, int k, int[] arr){
        boolean[][] dp = new boolean[n][k+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                //base case
                if (j==0){
                    dp[i][0]=true;
                }else if(i==0){
                    dp[0][j]=(arr[0]==j);
                }else {
                    boolean nonTake = dp[i-1][j];
                    boolean take = false;
                    if (j>=arr[i]){
                        take = dp[i-1][j-arr[i]];
                    }
                    dp[i][j] = take || nonTake;
                }
            }
        }

        return dp[n-1][k];
    }



    //Tabulation
    //TC: O(N*K)
    //SC: O(N*K)
    //Base cases written outside
    public static boolean subsetSumToK5(int n, int k, int[] arr){
        boolean[][] dp = new boolean[n][k+1];

        for (int i = 0; i < n; i++) {
            dp[i][0]=true;
        }

        if (arr[0]<=k){
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean nonTake = dp[i-1][j];
                boolean take = false;
                if (j>=arr[i]){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take || nonTake;

            }
        }

        return dp[n-1][k];
    }

    //Tabulation
    //Space Optimization
    //TC: O(N*K)
    //SC: O(K)
    public static boolean subsetSumToK6(int n, int k, int[] arr){
        boolean[] dp = new boolean[k+1];

        //base cases
        dp[0]=true;
        if (arr[0]<=k){
            dp[arr[0]]=true;
        }

        for (int i = 1; i < n; i++) {
            boolean[] cur = new boolean[k+1];
            cur[0]=true;
            for (int j = 1; j <= k; j++) {
                boolean nonTake = dp[j];
                boolean take = false;
                if (j>=arr[i]){
                    take = dp[j-arr[i]];
                }
                cur[j] = take || nonTake;
            }
            dp = cur;
        }

        return dp[k];
    }





}
