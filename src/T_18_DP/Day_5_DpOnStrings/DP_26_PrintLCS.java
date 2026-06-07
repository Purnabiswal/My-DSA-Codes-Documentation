package src.T_18_DP.Day_5_DpOnStrings;

import java.util.Arrays;


//Naukri.com: https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383
public class DP_26_PrintLCS {
    public static void main(String[] args) {
        String text1="abcde";
        String text2="bdgek";
        int n=text1.length();
        int m=text2.length();

        //Inefficient ones
        System.out.println(findLCS(n, m, text1, text2));
        System.out.println(findLCS2(n, m, text1, text2));
        System.out.println(findLCS3(n, m, text1, text2));

        //Efficient ones:
        System.out.println(findLCS5(n, m, text1, text2));
        System.out.println(findLCS4(n, m, text1, text2));

    }


    //Efficient ones:



    //Final Tabulation
    //TC: O(n * m) + O(n+m)(backtrack)
    //SC: O(n * m)
    static public String findLCS5(int n, int m, String text1, String text2) {
        n=text1.length();
        m=text2.length();
        int[][] dp = new int[n+1][m+1];

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

//efficient
//        char[] s1 = str1.toCharArray();
//        char[] s2 = str2.toCharArray();
//        int n=s1.length;
//        int m=s2.length;
//        int[][] dp = new int[n+1][m+1];
//
//        for (int i = 1; i < n+1; i++) {
//            for (int j = 1; j < m+1; j++) {
//                int ans=0;
//                if (s1[i-1]==s2[j-1]){
//                    ans = 1+dp[i-1][j-1];
//                } else {
//                    int left = dp[i-1][j];
//                    int right = dp[i][j-1];
//                    ans = Math.max(left, right);
//                }
//                dp[i][j] = ans;
//            }
//        }

//        O(n+m)(backtrack)
        int k=dp[n][m];
        StringBuilder sb = new StringBuilder(k);
        int i=n;
        int j=m;
        while (i>0 && j>0){
            if (text1.charAt(i-1)==text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }else if (dp[i-1][j]>dp[i][j-1]){
                i=i-1;
            }else {
                j=j-1;
            }
        }

        return sb.reverse().toString();
    }





    //Tabulation
    //Very inefficient way
    //TC: O(n * m)
    //SC: O(n * m)
    static public String findLCS4(int n, int m, String text1, String text2) {
        n=text1.length();
        m=text2.length();
        int[][] dp = new int[n+1][m+1];

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
        return track(n, m, text1, text2, dp);
    }

    static public String track(int i, int j, String text1, String text2, int[][] dp){
        if (i==0 || j==0) return "";

        if (text1.charAt(i-1)==text2.charAt(j-1)){
            return track(i-1,j-1, text1, text2, dp)+text1.charAt(i-1);
        }else {
            if (dp[i-1][j]>dp[i][j-1]){
                return track(i-1, j, text1, text2, dp);
            }else {
                return track(i, j-1, text1, text2, dp);
            }
        }
    }























    //Inefficient ones:

    //Recursion
    //TC: O(2^n * 2^m)
    public static String findLCS(int n, int m, String s1, String s2){
        n=s1.length();
        m=s2.length();

        return f(n, m, s1, s2);
    }
    static public String f(int i, int j, String s1, String s2){
        if (i==0 || j==0){
            return "";
        }
        char ch1=s1.charAt(i-1);
        char ch2=s2.charAt(j-1);

        if (ch1==ch2){
            return f(i-1, j-1, s1, s2)+ch1;
        }else {
            String left = f(i-1, j, s1, s2);
            String right = f(i, j-1, s1, s2);
            return  (left.length()>right.length())?left:right;
        }
    }

    //Memo
    //TC: O(n * m)
    //SC: O(n * m) + O(n+m)(stack)
    public static String findLCS2(int n, int m, String s1, String s2){
        n=s1.length();
        m=s2.length();
        String[][] dp = new String[n+1][m+1];
        for (String[] e : dp){
            Arrays.fill(e, "");
        }
        return f2(n, m, s1, s2, dp);
    }
    static public String f2(int i, int j, String s1, String s2, String[][] dp){
        if (i==0 || j==0){
            return "";
        }

        if (!dp[i][j].isEmpty()){
            return dp[i][j];
        }

        char ch1=s1.charAt(i-1);
        char ch2=s2.charAt(j-1);

        if (ch1==ch2){
            return dp[i][j]=f2(i-1, j-1, s1, s2, dp)+ch1;
        }else {
            String left = f2(i-1, j, s1, s2, dp);
            String right = f2(i, j-1, s1, s2, dp);
            return  dp[i][j]=(left.length()>right.length())?left:right;
        }
    }



    //Tabulation
    //Inefficient
    //TC: O(n * m)
    //SC: O(n * m)
    public static String findLCS3(int n, int m, String s1, String s2){
        n=s1.length();
        m=s2.length();
        String[][] dp = new String[n+1][m+1];
        for (String[] e : dp){
            Arrays.fill(e, ""); //by default value is null in string dp
        }



        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                char ch1=s1.charAt(i-1);
                char ch2=s2.charAt(j-1);
                if (ch1==ch2){
                    dp[i][j] = dp[i-1][j-1]+ch1;
                } else {
                    String left = dp[i-1][j];
                    String right = dp[i][j-1];
                    dp[i][j] = (left.length()>right.length())?left:right;
                }
            }
        }

        return dp[n][m];
    }


}
