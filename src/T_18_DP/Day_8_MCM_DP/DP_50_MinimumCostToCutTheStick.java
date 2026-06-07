package src.T_18_DP.Day_8_MCM_DP;

import java.util.Arrays;

//similar one: https://www.naukri.com/code360/problems/cost-to-cut-a-chocolate_3208460
//LC_1547
public class DP_50_MinimumCostToCutTheStick {
    public static void main(String[] args) {
        int[] cuts={1,3,4,5};
        System.out.println(minCost(7, cuts));
        System.out.println(minCost4(7, cuts));
        System.out.println(minCost5(7, cuts));
    }

    //Best way:

    //Memo
    //TC: O(m^3) nearly
    //SC: O(m^2) + stack space
    static public int minCost4(int n, int[] cuts) {
        int c=cuts.length;
        Arrays.sort(cuts);
        int[] arr=new int[c+2];
        arr[0]=0;
        arr[c+1]=n;
        for (int i = 1; i < c+1; i++) {
            arr[i]=cuts[i-1];
        }
        int[][] dp=new int[c+1][c+1];
        for (int[] e:dp){
            Arrays.fill(e, -1);
        }
        return f4(1, c, arr, dp);
    }
    static public int f4(int i, int j, int[] arr, int[][] dp){
        if(i>j) return 0;
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=(int) 1e9, cost;
        for (int k = i; k <= j; k++) {
            cost=(arr[j+1]-arr[i-1])+f4(i, k-1, arr, dp)+f4(k+1, j, arr, dp);
            if (cost<min) min=cost;
        }

        return dp[i][j]=min;
    }




    //Tabulation
    //TC: O(m^3) nearly
    //SC: O(m^2)
    static public int minCost5(int n, int[] cuts) {
        int c=cuts.length;
        Arrays.sort(cuts);
        int[] arr=new int[c+2];
        arr[0]=0;
        arr[c+1]=n;
        for (int i = 1; i < c+1; i++) {
            arr[i]=cuts[i-1];
        }
        int[][] dp=new int[c+2][c+2];


        for (int i = c; i >= 1; i--) {
            for (int j = i; j <= c; j++) {
                int min=(int) 1e9, cost;
                for (int k = i; k <= j; k++) {
                    cost=(arr[j+1]-arr[i-1])+dp[i][k-1]+dp[k+1][j];
                    if (cost<min) min=cost;
                }
                dp[i][j]=min;
            }
        }

        return dp[1][c];
    }







































    //My way: In come cases memory limit exceeds the following ocde

    //Recursion
    static public int minCost(int n, int[] cuts) {
        return f(0, n, cuts);
    }
    static public int f(int i, int j, int[] cuts){
        int min=(int) 1e9, cost;
        for (int k = 0; k < cuts.length; k++) {
            if (cuts[k]>i && cuts[k]<j){
                cost=(j-i)+f(i, cuts[k], cuts)+f(cuts[k], j, cuts);
                if (cost<min) min=cost;
            }
        }

        return (min==(int) 1e9)?0:min;
    }



    //Memo
    static public int minCost2(int n, int[] cuts) {
        int[][] dp=new int[n][n];
        for (int[] e:dp){
            Arrays.fill(e, -1);
        }
        return f2(0, n, cuts, dp);
    }
    static public int f2(int i, int j, int[] cuts, int[][] dp){

        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=(int) 1e9, cost;
        for (int k = 0; k < cuts.length; k++) {
            if (cuts[k]>i && cuts[k]<j){
                cost=(j-i)+f2(i, cuts[k], cuts, dp)+f2(cuts[k], j, cuts, dp);
                if (cost<min) min=cost;
            }
        }

        return dp[i][j]=(min==(int) 1e9)?0:min;
    }









}
