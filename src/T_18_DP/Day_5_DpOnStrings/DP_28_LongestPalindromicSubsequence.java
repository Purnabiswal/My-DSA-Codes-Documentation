package src.T_18_DP.Day_5_DpOnStrings;


//LC_516 https://leetcode.com/problems/longest-palindromic-subsequence/description/
//Naukri.com https://www.naukri.com/code360/problems/longest-palindromic-subsequence_842787
public class DP_28_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        DP_28_LongestPalindromicSubsequence ob = new DP_28_LongestPalindromicSubsequence();
        String s="cbbd";
        System.out.println(ob.longestPalindromeSubseq(s));
        System.out.println(ob.longestPalindromeSubseq2(s));
    }

    public int longestPalindromeSubseq(String s) {
        return f(0, s.length()-1, s.toCharArray());
    }

    public int f(int n, int m, char[] s){
        if(n==m) return 1;
        if(n>m) return 0;

        if(s[n]==s[m]){
            return 2+f(n+1,m-1, s);
        }else{
            return Math.max(f(n+1, m, s), f(n, m-1, s));
        }
    }



    //Another way
    public int longestPalindromeSubseq2(String s) {
        int n=s.length();
        char[] s1=s.toCharArray();
        char[] s2= new char[n];
        int j=n-1;
        for (int i = 0; i < n; i++) {
            s2[j--]=s1[i];
        }
        return lcs(s1, s2);
    }
    //lcs
    //Tabulation
    //Efficient
    //TC: O(n * m)
    //SC: O(n * m)
    static public int lcs(char[] text1, char[] text2) {
        int n=text1.length;
        int m=text2.length;
        int[] prev = new int[m+1];



        for (int i = 1; i < n+1; i++) {
            int[] cur = new int[m+1];
            for (int j = 1; j < m+1; j++) {
                if (text1[i-1]==text2[j-1]){
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
