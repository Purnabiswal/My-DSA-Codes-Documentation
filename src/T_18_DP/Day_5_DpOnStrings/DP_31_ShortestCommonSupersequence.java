package src.T_18_DP.Day_5_DpOnStrings;

//SCS
//LC_1092
//https://www.naukri.com/code360/problems/shortest-common-supersequence_11768807
public class DP_31_ShortestCommonSupersequence {
    public static void main(String[] args) {
        String text1="rabbbit";
        String text2="rabbit";
        int n=text1.length();
        int m=text2.length();

        System.out.println(findLCS(text1, text2));
    }



    static public String findLCS(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n=s1.length;
        int m=s2.length;
        int[][] dp = new int[n+1][m+1];

        //lcs code
        for (int i = 1; i < n+1; i++) {
            char ch=s1[i-1];
            for (int j = 1; j < m+1; j++) {
                dp[i][j] = (ch==s2[j-1])?1+dp[i-1][j-1]:Math.max(dp[i-1][j], dp[i][j-1]);
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
            if (s1[i-1]==s2[j-1]){
                sb.append(s1[i-1]);
                i--;
                j--;
            }else if (dp[i-1][j]>dp[i][j-1]){
                sb.append(s1[i-1]);
                i=i-1;
            } else {
                sb.append(s2[j-1]);
                j=j-1;
            }
        }
        if (i==0){
            return str2.substring(0, j)+sb.reverse();
        }else if (j==0){
            return str1.substring(0, i)+sb.reverse();
        }

        return sb.reverse().toString();
    }
}
