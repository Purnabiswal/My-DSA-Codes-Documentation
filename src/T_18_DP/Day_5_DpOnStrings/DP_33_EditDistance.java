package src.T_18_DP.Day_5_DpOnStrings;

import java.util.Arrays;

//LC_72
//https://www.naukri.com/code360/problems/minimum-insertions-deletions-to-convert-string-a-to-string-b_630420
public class DP_33_EditDistance {
    public static void main(String[] args) {
        String text1="intention";
        String text2="execution";
        System.out.println(minDistance(text1, text2));
        System.out.println(minDistance2(text1, text2));
        System.out.println(minDistance3(text1, text2));
        System.out.println(minDistance4(text1, text2));
        System.out.println(minDistance5(text1, text2));
        System.out.println(minDistance6(text1, text2));
    }

    //recursion
    //TC: (3^m*3^n)
    //SC: (m+n)
    static public int minDistance(String word1, String word2) {
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        int m=s1.length;
        int n=s2.length;
        return f(m-1, n-1, s1, s2);
    }

    static public int f(int m, int n, char[] s1, char[] s2){
        if(n<0) return m+1;
        if(m<0) return n+1;

        if (s1[m]==s2[n]){
            return f(m-1, n-1, s1, s2);
        }
        int left=f(m-1, n, s1, s2)+1;
        int mid=f(m, n-1, s1, s2)+1;
        int right=f(m-1, n-1, s1, s2)+1;
        return Math.min(left, Math.min(mid, right));
    }


    //recursion with shifting of indices
    //TC: (3^m*3^n)
    //SC: (m+n)
    static public int minDistance2(String word1, String word2) {
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        int m=s1.length;
        int n=s2.length;
        return f2(m, n, s1, s2);
    }

    static public int f2(int m, int n, char[] s1, char[] s2){
        if(n==0) return m;
        if(m==0) return n;

        if (s1[m-1]==s2[n-1]){
            return f2(m-1, n-1, s1, s2);
        }
        int left=f2(m-1, n, s1, s2)+1;
        int mid=f2(m, n-1, s1, s2)+1;
        int right=f2(m-1, n-1, s1, s2)+1;
        return Math.min(left, Math.min(mid, right));
    }

    //memo
    //TC: O(m*n)
    //SC: O(m*n) + O(m+n)
    static public int minDistance3(String word1, String word2) {
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        int m=s1.length;
        int n=s2.length;
        int[][] dp=new int[m+1][n+1];
        for(int[] e:dp){
            Arrays.fill(e, -1);
        }
        return f3(m, n, s1, s2, dp);
    }

    static public int f3(int m, int n, char[] s1, char[] s2, int[][] dp){
        if(n==0) return m;
        if(m==0) return n;

        if (dp[m][n]!=-1){
            return dp[m][n];
        }
        if (s1[m-1]==s2[n-1]){
            return dp[m][n]=f3(m-1, n-1, s1, s2, dp);
        }
        int left=f3(m-1, n, s1, s2, dp)+1; //delete
        int mid=f3(m, n-1, s1, s2, dp)+1; //insert
        int right=f3(m-1, n-1, s1, s2, dp)+1; //replace
        return dp[m][n]=Math.min(left, Math.min(mid, right));
    }


    //Tabulation
    //TC: O(m*n)
    //SC: O(m*n)
    static public int minDistance4(String word1, String word2) {
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        int m=s1.length;
        int n=s2.length;
        int[][] dp=new int[m+1][n+1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i]=i;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (s1[i-1]==s2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                }
            }
        }


        return dp[m][n];
    }

    //Tabulation
    //space optimized
    //TC: O(m*n)
    //SC: O(m*n)
    static public int minDistance5(String word1, String word2) {
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        int m=s1.length;
        int n=s2.length;
        int[] prev=new int[n+1];


        for (int i = 0; i < n + 1; i++) {
            prev[i]=i;
        }

        for (int i = 1; i < m+1; i++) {
            int[] cur=new int[n+1];
            cur[0]=i;
            for (int j = 1; j < n+1; j++) {
                if (s1[i-1]==s2[j-1]){
                    cur[j] = prev[j-1];
                }else {
                    cur[j] = Math.min(prev[j],Math.min(cur[j-1], prev[j-1]))+1;
                }
            }
            prev=cur;
        }


        return prev[n];
    }


    //Tabulation
    //Further space optimized
    //TC: O(m*n)
    //SC: O(m*n)
    static public int minDistance6(String word1, String word2) {
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        int m=s1.length;
        int n=s2.length;
        int x=0;
        int y=0;
        int[] prev=new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            prev[i]=i;
        }
        for (int i = 1; i < m+1; i++) {
            prev[0]=i;
            x=i-1;
            for (int j = 1; j < n+1; j++) {
                y=prev[j];
                if (s1[i-1]==s2[j-1]){
                    prev[j] = x;
                }else {
                    prev[j] = Math.min(prev[j],Math.min(prev[j-1], x))+1;
                }
                x=y;
            }
        }
        return prev[n];
    }
}
