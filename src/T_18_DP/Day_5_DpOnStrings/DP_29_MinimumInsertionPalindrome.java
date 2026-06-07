package src.T_18_DP.Day_5_DpOnStrings;

//LC_1312 https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
//Naukri.com https://www.naukri.com/code360/problems/minimum-insertions-to-make-a-string-palindrome_985293
public class DP_29_MinimumInsertionPalindrome {
    public static void main(String[] args) {

    }


    public int minInsertions(String s) {
        int n=s.length();
        char[] s1=s.toCharArray();
        char[] s2= new char[n];
        int j=n-1;
        for (int i = 0; i < n; i++) {
            s2[j--]=s1[i];
        }
        return n-lcs(s1, s2);
    }
    public int lcs(char[] text1, char[] text2) {
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
