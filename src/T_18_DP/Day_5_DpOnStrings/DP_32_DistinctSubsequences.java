package src.T_18_DP.Day_5_DpOnStrings;

import java.util.Arrays;


//LC_115
//Naukri.com
public class DP_32_DistinctSubsequences {
    public static void main(String[] args) {
        String text1="rabbbit";
        String text2="rabbit";


        System.out.println(findLCS(text1, text2));
        System.out.println();
        System.out.println(numDistinct(text1, text2));
        System.out.println(numDistinct2(text1, text2));
        System.out.println(numDistinct3(text1, text2));
        System.out.println(numDistinct4(text1, text2));
        System.out.println(numDistinct5(text1, text2));
        System.out.println(numDistinct6(text1, text2));
    }

    //recursion
    //TC: O(2^n*2^m)
    //SC: O(n+m)
    static public int numDistinct(String s, String t) {
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        int m=s1.length;
        int n=s2.length;
        return f(m-1, n-1, s1, s2);
    }

    static public int f(int m, int n, char[] s1, char[] s2){
        if (n<0) return 1;
        if (m<0) return 0;

        char ch1=s1[m];
        char ch2=s2[n];
        int ans=0;
        if (ch1==ch2){
            ans=f(m-1, n-1, s1, s2);
        }
        ans+=f(m-1, n, s1, s2);
        return ans;
    }

    //recursion shifted indices e.g., 0->1
    //TC: O(2^n*2^m)
    //SC: O(n+m)
    static public int numDistinct2(String s, String t) {
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        int m=s1.length;
        int n=s2.length;
        return f2(m, n, s1, s2);
    }

    static public int f2(int m, int n, char[] s1, char[] s2){
        if (n==0) return 1;
        if (m==0) return 0;

        char ch1=s1[m-1];
        char ch2=s2[n-1];
        int ans=0;
        if (ch1==ch2){
            ans=f2(m-1, n-1, s1, s2);
        }
        ans+=f2(m-1, n, s1, s2);
        return ans;
    }


    //memo
    //TC: O(n*m)
    //SC: O(n*m) + O(n+m)
    static public int numDistinct3(String s, String t) {
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        int m=s1.length;
        int n=s2.length;
        int[][] dp=new int[m+1][n+1];
        for (int[] e: dp){
            Arrays.fill(e, -1);
        }
        return f3(m, n, s1, s2, dp);
    }
    static public int f3(int m, int n, char[] s1, char[] s2, int[][] dp){
        if (n==0) return 1;
        if (m==0) return 0;
        if (dp[m][n]!=-1){
            return dp[m][n];
        }
        char ch1=s1[m-1];
        char ch2=s2[n-1];
        int ans=0;
        if (ch1==ch2){
            ans=f3(m-1, n-1, s1, s2, dp);
        }
        ans+=f3(m-1, n, s1, s2, dp);
        return dp[m][n]=ans;
    }


    //Tabulation
    //TC: O(n*m)
    //SC: O(n*m)
    static public int numDistinct4(String s, String t) {
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        int m=s1.length;
        int n=s2.length;
        int[][] dp=new int[m+1][n+1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0]=1;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                int ans=0;
                if (s1[i-1]==s2[j-1]){
                    ans=dp[i-1][j-1];
                }
                dp[i][j] = ans+dp[i-1][j];
            }
        }

        return dp[m][n];
    }

    //Tabulation
    //More optimized
    static public int numDistinct5(String s, String t) {
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        int m=s1.length;
        int n=s2.length;
        int[] prev=new int[n+1];

        prev[0]=1;

        for (int i = 1; i < m+1; i++){
            int[] cur=new int[n+1];
            cur[0]=1;
            for (int j = 1; j < n+1; j++) {
                int ans=0;
                if (s1[i-1]==s2[j-1]){
                    ans=prev[j-1];
                }
                cur[j] = ans+prev[j];
            }
            prev=cur;
        }

        return prev[n];
    }




    //Tabulation
    //1D array
    //More optimized
    static public int numDistinct6(String s, String t) {
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        int m=s1.length;
        int n=s2.length;
        int[] prev=new int[n+1];

        prev[0]=1;

        for (int i = 1; i < m+1; i++){
            for (int j = n; j >= 1; j--) {
                int ans=0;
                if (s1[i-1]==s2[j-1]){
                    prev[j]+=prev[j-1];
                }
            }
        }

        return prev[n];
    }
























    static public String findLCS(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n=s1.length;
        int m=s2.length;
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int ans=0;
                if (s1[i-1]==s2[j-1]){
                    ans = 1+dp[i-1][j-1];
                } else {
                    int left = dp[i-1][j];
                    int right = dp[i][j-1];
                    ans = Math.max(left, right);
                }
                dp[i][j] = ans;
            }
        }

        System.out.print("    ");
        for (int i = 0; i < m; i++) {
            System.out.print(str2.charAt(i)+" ");
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < n + 1; i++) {
            if (i!=0){
                System.out.print(s1[i-1]+" ");
            }
            for (int j = 0; j < m + 1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

//        O(n+m)(backtrack)
        int k=dp[n][m];
        StringBuilder sb = new StringBuilder(k);
        int i=n;
        int j=m;
        while (i>0 && j>0){
            if (str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
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

}
