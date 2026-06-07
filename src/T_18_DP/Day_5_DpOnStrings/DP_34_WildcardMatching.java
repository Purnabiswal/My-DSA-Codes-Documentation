package src.T_18_DP.Day_5_DpOnStrings;

//LC_44
//https://www.naukri.com/code360/problems/wildcard-pattern-matching_701650
public class DP_34_WildcardMatching {
    public static void main(String[] args) {


        String text1="aa";
        String text2="a";
//        System.out.println(isMatch(text1, text2));
//        System.out.println(isMatch2(text1, text2));
        System.out.println(isMatch3(text1, text2));
        System.out.println(isMatch4(text1, text2));
//        System.out.println(isMatch5(text1, text2));

    }

    //recursion
    //TC: O(2^m*2^n) exponential
    //SC: O(m+n)
    static public boolean isMatch(String s, String p) {
        char[] s1=s.toCharArray();
        char[] s2=p.toCharArray();
        int m=s1.length;
        int n=s2.length;
        return f(m-1, n-1, s1, s2);
    }
    static public boolean f(int m, int n, char[] s1, char[] s2){
        if (m<0 && n<0) return true;
        if (n<0) return false;
        if (m<0){
            while (n>=0){
                char ch=s2[n];
                if (ch!='*'){
                    return false;
                }
                n--;
            }
            return true;
        }

        if (s1[m]==s2[n] || s2[n]=='?'){
            return f(m-1, n-1, s1, s2);
        }
        if (s2[n]=='*'){
            return f(m-1, n, s1, s2) || f(m-1, n-1, s1, s2) || f(m, n-1, s1, s2);
        }
        return false;
    }






    //recursion with shifting of indices
    //TC: O(2^n*2^m)
    //SC: O(n+m)
    static public boolean isMatch2(String s, String p) {
        char[] s1=s.toCharArray();
        char[] s2=p.toCharArray();
        int m=s1.length;
        int n=s2.length;
        return f2(m, n, s1, s2);
    }
    static public boolean f2(int m, int n, char[] s1, char[] s2){
        if (m==0 && n==0) return true;
        if (n==0) return false;
        if (m==0){
            while (n>0){
                char ch=s2[n-1];
                if (ch!='*'){
                    return false;
                }
                n--;
            }
            return true;
        }

        if (s1[m-1]==s2[n-1] || s2[n-1]=='?'){
            return f2(m-1, n-1, s1, s2);
        }
        if (s2[n-1]=='*'){
            return f2(m-1, n, s1, s2) || f2(m, n-1, s1, s2);
        }
        return false;
    }

    //memo
    //TC: O(n*m)
    //SC: O(n*m) + O(n+m)
    static public boolean isMatch3(String s, String p) {
        char[] s1=s.toCharArray();
        char[] s2=p.toCharArray();
        int m=s1.length;
        int n=s2.length;
        Boolean[][] dp=new Boolean[m+1][n+1];
        return f3(m, n, s1, s2, dp);
    }
    static public boolean f3(int m, int n, char[] s1, char[] s2, Boolean[][] dp) {
        if (m == 0 && n == 0) return true;
        if (n == 0) return false;
        if (m == 0) {
            for (int i = n; i > 0; i--) {
                char ch = s2[n - 1];
                if (ch != '*') {
                    return false;
                }
            }
            while (n > 0) {
                char ch = s2[n - 1];
                if (ch != '*') {
                    return false;
                }
                n--;
            }
            return true;
        }

        if (dp[m][n]!=null) {
            return dp[m][n];
        }

        if (s1[m - 1] == s2[n - 1] || s2[n - 1] == '?') {
            return dp[m][n] = f3(m - 1, n - 1, s1, s2, dp); //match
        }
        if (s2[n - 1] == '*') {
            return dp[m][n] = f3(m - 1, n, s1, s2, dp) || f3(m, n - 1, s1, s2, dp);
        }
        return dp[m][n] = false; //non match
    }




    //Tabulation
    //TC: O(n*m)
    //SC: O(n*m)
    static public boolean isMatch4(String s, String p) {
        char[] s1=s.toCharArray();
        char[] s2=p.toCharArray();
        int m=s1.length;
        int n=s2.length;
        Boolean[][] dp=new Boolean[m+1][n+1];

        dp[0][0]=true;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0]=false;
        }
        for (int i = 1; i < n+1; i++) {
            if (dp[0][i-1] && s2[i-1]=='*'){
                dp[0][i]=true;
            }else {
                dp[0][i]=false;
            }
        }
        //alternative single line
//        for (int i = 1; i < n+1; i++) {
//            dp[0][i]= dp[0][i - 1] && s2[i-1] == '*';
//        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (s1[i-1]==s2[j-1] || s2[j-1]=='?'){
                    dp[i][j]=dp[i-1][j-1];
                } else if (s2[j - 1] == '*') {
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }else {
                    dp[i][j]=false;
                }
            }
        }
        
        return dp[m][n];
    }


    //Tabulation
    //Space optimized
    //TC: O(n*m)
    static public boolean isMatch5(String s, String p) {
        char[] s1=s.toCharArray();
        char[] s2=p.toCharArray();
        int m=s1.length;
        int n=s2.length;
        Boolean[] prev =new Boolean[n+1];

        prev[0]=true;

        for (int i = 1; i < n+1; i++) {
            prev[i]= prev[i - 1] && s2[i-1] == '*';
        }

        for (int i = 1; i < m+1; i++) {
            Boolean[] cur=new Boolean[n+1];
            cur[0]=false;
            for (int j = 1; j < n+1; j++) {
                if (s1[i-1]==s2[j-1] || s2[j-1]=='?'){
                    cur[j]= prev[j-1];
                } else if (s2[j - 1] == '*') {
                    cur[j]= prev[j] || cur[j-1];
                }else {
                    cur[j]=false;
                }
            }
            prev=cur;
        }

        return prev[n];
    }

    //Tabulation
    //1D array
    // More Space optimized
    //Incomplete
    static public boolean isMatch6(String s, String p) {
        char[] s1=s.toCharArray();
        char[] s2=p.toCharArray();
        int m=s1.length;
        int n=s2.length;
        Boolean[] prev =new Boolean[n+1];

        prev[0]=true;

        for (int i = 1; i < n+1; i++) {
            prev[i]= prev[i - 1] && s2[i-1] == '*';
        }

        for (int i = 1; i < m+1; i++) {
            Boolean[] cur=new Boolean[n+1];
            cur[0]=false;
            for (int j = 1; j < n+1; j++) {
                if (s1[i-1]==s2[j-1] || s2[j-1]=='?'){
                    cur[j]= prev[j-1];
                } else if (s2[j - 1] == '*') {
                    cur[j]= prev[j] || cur[j-1];
                }else {
                    cur[j]=false;
                }
            }
            prev=cur;
        }

        return prev[n];
    }

}
