package src.T_18_DP.Day_5_DpOnStrings;

import java.util.Arrays;


//LC_1143 https://leetcode.com/problems/longest-common-subsequence/
//Naukri.com https://www.naukri.com/code360/problems/longest-common-subsequence_624879
public class DP_25_LCS_way2 {
    public static void main(String[] args) {

        String text1="abcde";
        String text2="ace";
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println(longestCommonSubsequence2(text1, text2));
        System.out.println(longestCommonSubsequence3(text1, text2));
        System.out.println(longestCommonSubsequence4(text1, text2));

    }


    //Way-2:

    //Recursion
    //TC: O(2^n * 2^m)
    static public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();

        return f(n, m, text1, text2);
    }

    static public int f(int i, int j, String s1, String s2){
        if (i==0 || j==0){
            return 0;
        }
        char ch1=s1.charAt(i-1);
        char ch2=s2.charAt(j-1);
        int ans=0;
        if (ch1==ch2){
            ans=1+f(i-1, j-1, s1, s2);
        }else {
            int left = f(i-1, j, s1, s2);
            int right = f(i, j-1, s1, s2);
            ans = Math.max(left, right);
        }

        return ans;
    }




    //Memoization
    //TC: O(n * m)
    //SC: O(n * m) + O(n+m)(stack)
    static public int longestCommonSubsequence2(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] e : dp){
            Arrays.fill(e, -1);
        }
        return f2(n, m, text1, text2, dp);
    }

    static public int f2(int i, int j, String s1, String s2,int[][] dp){
        if (i==0 || j==0){
            return 0;
        }

        if (dp[i][j]!=-1){
            return dp[i][j];
        }

        char ch1=s1.charAt(i-1);
        char ch2=s2.charAt(j-1);
        int ans=0;
        if (ch1==ch2){
            ans=1+f2(i-1, j-1, s1, s2, dp);
        }else {
            int left = f2(i-1, j, s1, s2, dp);
            int right = f2(i, j-1, s1, s2, dp);
            ans = Math.max(left, right);
        }

        return dp[i][j] = ans;
    }



    //Tabulation
    //TC: O(n * m)
    //SC: O(n * m)
    static public int longestCommonSubsequence3(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp = new int[n+1][m+1];

        //No need to do dp[0][i]=0; because java by default values are zero in an array
        for (int i = 0; i < m + 1; i++) {
            dp[0][i]=0;
        }
        //No need to do dp[i][0]=0; because java by default values are zero in an array
        for (int i = 0; i < n + 1; i++) {
            dp[i][0]=0;
        }


        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int ans=0;
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    ans = 1+dp[i-1][j-1];
                } else {
                    int left = dp[i-1][j];
                    int right = dp[i][j-1];
                    ans = Math.max(left, right);
                }
                dp[i][j] = ans;
            }
        }

        return dp[n][m];
    }


    //Tabulation
    //Efficient
    //TC: O(n * m)
    //SC: O(n * m)
    static public int longestCommonSubsequence4(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[] prev = new int[m+1];



        for (int i = 1; i < n+1; i++) {
            int[] cur = new int[m+1];
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    cur[j] = 1+prev[j-1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j-1]);
                }
            }
            prev = cur;
        }

        return prev[m];
    }





}
