package src.T_18_DP.Day_5_DpOnStrings;


//Similar on leetcode. LC_718 https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
//Naukri.com https://www.naukri.com/code360/problems/longest-common-substring_1235207
public class DP_27_LCSubstring {
    public static void main(String[] args) {

    }

    //Tabulation
    //TC: O(n * m)
    //SC: O(n * m)
    public static int lcs(String str1, String str2){
        int n=str1.length();
        int m=str2.length();
        int[][] dp = new int[n+1][m+1];

        int max=0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    max=Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }

    //Tabulation
    //TC: O(n * m)
    //SC: O(n * m)
    public static int lcs2(String str1, String str2){
        int n=str1.length();
        int m=str2.length();
        int[] prev = new int[m+1];

        int max=0;
        for (int i = 1; i < n+1; i++) {
            int[] cur = new int[m+1];
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    cur[j] = 1+prev[j-1];
                    max=Math.max(max, cur[j]);
                }
            }
            prev=cur;
        }

        return max;
    }



    //wrong output
    //Reason: 💥 The fatal issue
    //prev = cur;
    //
    //
    //After the first iteration:
    //
    //prev and cur point to THE SAME array in memory
    //
    //
    //So on the next i:
    //
    //You overwrite cur[j]
    //
    //Which also overwrites prev[j]
    //
    //But prev[j-1] is needed for DP transition ❌
    //
    //👉 You destroy the previous row while still using it
    public static int lcs3(String str1, String str2){
        int n=str1.length();
        int m=str2.length();
        int[] prev = new int[m+1];
        int[] cur = new int[m+1];

        int max=0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    cur[j] = 1+prev[j-1];
                    max=Math.max(max, cur[j]);
                }else{
                    cur[j]=0;
                }
            }
            prev=cur;
        }

        return max;
    }

}
