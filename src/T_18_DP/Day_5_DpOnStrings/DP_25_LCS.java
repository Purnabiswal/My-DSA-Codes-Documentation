package src.T_18_DP.Day_5_DpOnStrings;

import java.util.Arrays;

public class DP_25_LCS {
    public static void main(String[] args) {

        String text1="abcde";
        String text2="ace";
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println(longestCommonSubsequence2(text1, text2));
        System.out.println(longestCommonSubsequence3(text1, text2));

    }


    //Way-1:

    //Recursion
    //TC: O(2^n * 2^m)
    static public int longestCommonSubsequence(String text1, String text2) {
        return f(text1.length()-1, text2.length()-1, text1, text2);
    }

    static public int f(int i, int j, String s1, String s2){
        if (i<0 || j<0){
            return 0;
        }
        char ch1=s1.charAt(i);
        char ch2=s2.charAt(j);
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
    //TC: O(n * m) + O(n+m)(stack)
    static public int longestCommonSubsequence2(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp = new int[n][m];
        for (int[] e : dp){
            Arrays.fill(e, -1);
        }
        return f2(n-1, m-1, text1, text2, dp);
    }

    static public int f2(int i, int j, String s1, String s2,int[][] dp){
        if (i<0 || j<0){
            return 0;
        }

        if (dp[i][j]!=-1){
            return dp[i][j];
        }

        char ch1=s1.charAt(i);
        char ch2=s2.charAt(j);
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
    //TC: O(n * m)
    static public int longestCommonSubsequence3(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp = new int[n][m];

        char ch1=text1.charAt(0);
        char ch2=text2.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i+1; j++) {
                if (ch1==text2.charAt(j)){
                    dp[0][i] = 1;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                if (ch2==text1.charAt(j)){
                    dp[i][0] = 1;
                    break;
                }
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int ans=0;
                if (text1.charAt(i)==text2.charAt(j)){
                    ans = 1+dp[i-1][j-1];
                } else {
                    int left = dp[i-1][j];
                    int right = dp[i][j-1];
                    ans = Math.max(left, right);
                }
                dp[i][j] = ans;
            }
        }

        return dp[n-1][m-1];
    }







}
