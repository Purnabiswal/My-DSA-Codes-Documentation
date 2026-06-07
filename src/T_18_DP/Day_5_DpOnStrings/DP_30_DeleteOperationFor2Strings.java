package src.T_18_DP.Day_5_DpOnStrings;



//LC_583 https://leetcode.com/problems/delete-operation-for-two-strings/
//Naukri.com https://www.naukri.com/code360/problems/can-you-make_4244510

//Try out: https://www.naukri.com/code360/problems/minimum-insertions-deletions-to-convert-string-a-to-string-b_630420
public class DP_30_DeleteOperationFor2Strings {
    public static void main(String[] args) {
        String s1="acdefgd";
        String s2="aawdfg";
        System.out.println(minDistance(s1, s2));
    }


    //TC:O(N*M)
    static public int minDistance(String word1, String word2) {
        return (word1.length()+word2.length())-(2*lcs(word1, word2));
    }
    static public int lcs(String text1, String text2) {
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
