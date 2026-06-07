package src.T_18_DP.Day_8_MCM_DP;

import java.util.Arrays;

//LC_132
//https://www.naukri.com/code360/problems/palindrome-partitioning_873266
public class DP_53_PalindromePartitioning_2_FrontPartition {
    public static void main(String[] args) {
//        String s="aaccb";
        String s="ababababababababababababcbabababababababababababa";
//        System.out.println(minCut(s));
        System.out.println(minCut2(s));
        System.out.println(minCut3(s));
    }

    //Try out similar: LC_131. Palindrome Partitioning


    //Universal palindrome checker
    private static boolean isPalindrome(int i, int j, char[] s) {
        while (i<j){
            if (s[i]!=s[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //Recursion
    //TC: O(exponential)
    //SC: O(n)
    static public int minCut(String s) {
        char[] chars=s.toCharArray();
        int n = chars.length;
        return f(0, n, chars);
    }
    static public int f(int i, int n, char[] s){
        if (i==n-1) return 0;

        int min=Integer.MAX_VALUE;
        for (int k = i; k < n; k++) {
            int ways;
            if (isPalindrome(i, k, s)){
                if (k==n-1){
                    ways=0; //don't cut at last
                }else {
                    ways=1+f(k+1, n, s);
                }
                min=Math.min(min, ways);
            }
        }
        return min;
    }




    //Memo
    //TC: O(n^3)
    //SC: O(n) + O(n)
    static public int minCut2(String s) {
        char[] chars=s.toCharArray();
        int n = chars.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        return f2(0, n, chars, dp);
    }
    static public int f2(int i, int n, char[] s, int[] dp){
        if (i==n-1) return 0;

        if (dp[i]!=-1){
            return dp[i];
        }
        int min=Integer.MAX_VALUE;
        for (int k = i; k < n; k++) {
            int ways;
            if (isPalindrome(i, k, s)){
                if (k==n-1){
                    ways=0;
                }else {
                    ways=1+f2(k+1, n, s, dp);
                }
                min=Math.min(min, ways);
            }
        }
        return dp[i]=min;
    }



    //Tabulation
    //TC: O(n^3)
    //SC: O(n)
    static public int minCut3(String s) {
        char[] chars=s.toCharArray();
        int n = chars.length;
        int[] dp=new int[n];

        for (int i = n-2; i >= 0; i--) {
            int min=Integer.MAX_VALUE;
            for (int k = i; k < n; k++) {
                int ways;
                if (isPalindrome(i, k, chars)){
                    if (k==n-1){
                        ways=0;
                    }else {
                        ways=1+dp[k+1];
                    }
                    min=Math.min(min, ways);
                }
            }
            dp[i]=min;
        }


        return dp[0];
    }



    //striver's version - not as such difference
//    static public int minCut(String s) {
//        char[] chars=s.toCharArray();
//        int n = chars.length;
//        int[] dp=new int[n];
//        Arrays.fill(dp, -1);
//        return f2(0, n, chars, dp)-1;
//    }
//    static public int f2(int i, int n, char[] s, int[] dp){
//        if (i==n) return 0;
//
//        if (dp[i]!=-1){
//            return dp[i];
//        }
//        int min=Integer.MAX_VALUE;
//        for (int k = i; k < n; k++) {
//            int ways;
//            if (isPalindrome(i, k, s)){
//                ways=1+f2(k+1, n, s, dp);
//
//                min=Math.min(min, ways);
//            }
//        }
//        return dp[i]=min;
//    }
//
//    private static boolean isPalindrome(int i, int j, char[] s) {
//        while (i<j){
//            if (s[i]!=s[j]){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
}
