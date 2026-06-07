package src.T_18_DP.Day_8_MCM_DP;

import java.util.Arrays;

//LC_1106 - similar one
//https://www.naukri.com/code360/problems/problem-name-boolean-evaluation_1214650
public class DP_52_EvaluateBooleanExpressionToTrue {
    public static void main(String[] args) {
        System.out.println(true^true);
        System.out.println(true^false);
        System.out.println(false^true);
        System.out.println(false^false);

        System.out.println(1^1);
        System.out.println(1^0);
        System.out.println(0^1);
        System.out.println(0^0);

        System.out.println();

        System.out.println(1|1);
        System.out.println(1|0);
        System.out.println(0|1);
        System.out.println(0|0);

        System.out.println();

        System.out.println(1&1);
        System.out.println(1&0);
        System.out.println(0&1);
        System.out.println(0&0);

//        String exp="T^F&F|T";
//        System.out.println( exp.charAt(1));
//        System.out.println();


        System.out.println();
//        String exp="T^F|T&F^T|F";
//        String exp="T^T|F|T";
        String exp="F^F^F^F&T|T|F|T|F|F|T|T|T|T&T|T|T&T|F&T|F|T|T|T^T|F^T|T&F^T|F|T|F|T&T|T^F|F^T&T^T&T^T&T^T&F&T^F|F^T|T|F|F^F|F&F|F|T&F&F";
//        System.out.println(evaluateExp(exp));
        System.out.println(evaluateExp2(exp));
        System.out.println(evaluateExp3(exp));


    }

    //Note- solve leetcode 1106 problem

    //Recursion
    //TC: exponential
    static int mod=1000000007;
    public static int evaluateExp(String exp) {
        int n=exp.length();
        char[] str=exp.toCharArray();
        return f(0, n-1, 1, str);
    }
    public static int f(int i, int j, int isTrue, char[] str){
        if (i>j) return 0;
        if (i==j){
            if (str[i]=='T' && isTrue==1) return 1;
            if (str[i]=='F' && isTrue==0) return 1; //check notebook base cases for better understanding
            return 0;
        }

        int ways=0;

        for (int k = i+1; k <= j-1; k+=2) {
            //left calls
            int x1=f(i, k-1, 1, str);
            int x2=f(i, k-1, 0, str);
            //right
            int x3=f(k+1, j, 1, str);
            int x4=f(k+1, j, 0, str);

            char op=str[k];

            if (op=='^'){
                ways+=(isTrue==1)?(x1*x4)+(x2*x3):(x1*x3)+(x2*x4);
            } else if (op=='&'){
                ways+=(isTrue==1)?(x1*x3):(x1*x4)+(x2*x3)+(x2*x4);
            } else if (op=='|'){
                ways+=(isTrue==1)?(x1*x3)+(x1*x4)+(x2*x3):(x2*x4);
            }

            ways=ways%mod;
        }
        return ways;
    }






    //Memo
    //TC: O(n*n*2)*n = O(n^3)
    //SC: O(n*n*2) = O(n^2) + auxiliary stack space
    public static int evaluateExp2(String exp) {
        int n=exp.length();
        char[] str=exp.toCharArray();

        int[][][] dp=new int[n][n][2];
        for (int[][] e:dp){
            for (int[] a:e){
                Arrays.fill(a, -1);
            }
        }
        return f2(0, n-1, 1, str, dp);
    }
    public static int f2(int i, int j, int isTrue, char[] str, int[][][] dp){
        if (i>j) return 0;
        if (i==j){
            if (str[i]=='T' && isTrue==1) return 1;
            if (str[i]=='F' && isTrue==0) return 1; //check notebook base cases for better understanding
            return 0;
        }

        if (dp[i][j][isTrue]!=-1){
            return dp[i][j][isTrue];
        }

        long ways=0;

        for (int k = i+1; k <= j-1; k+=2) {
            //left calls
            long x1=f2(i, k-1, 1, str, dp);
            long x2=f2(i, k-1, 0, str, dp);
            //right
            long x3=f2(k+1, j, 1, str, dp);
            long x4=f2(k+1, j, 0, str, dp);

            char op=str[k];

            if (op=='^'){
                ways+=(isTrue==1)?(x1*x4)+(x2*x3):(x1*x3)+(x2*x4);
            } else if (op=='&'){
                ways+=(isTrue==1)?(x1*x3):(x1*x4)+(x2*x3)+(x2*x4);
            } else if (op=='|'){
                ways+=(isTrue==1)?(x1*x3)+(x1*x4)+(x2*x3):(x2*x4);
            }

            ways=ways%mod;
        }
        return dp[i][j][isTrue]=(int)ways;
    }



    //Tabulation
    //TC: O(n*n*2)*n = O(n^3)
    //SC: O(n*n*2) = O(n^2)
    public static int evaluateExp3(String exp) {
        int n=exp.length();
        char[] str=exp.toCharArray();
        int[][][] dp=new int[n][n][2];

        //base case
        for (int i = 0; i < n; i++) {
            if (str[i]=='T'){
                dp[i][i][1]=1;
            } else if (str[i] == 'F') {
                dp[i][i][0]=1;
            }
        }


        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= n-1; j++) {
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    long ways=0;

                    for (int k = i+1; k <= j-1; k+=2) {
                        //left calls
                        long x1=dp[i][k-1][1];
                        long x2=dp[i][k-1][0];
                        //right
                        long x3=dp[k+1][j][1];
                        long x4=dp[k+1][j][0];

                        char op=str[k];

                        if (op=='^'){
                            ways+=(isTrue==1)?(x1*x4)+(x2*x3):(x1*x3)+(x2*x4);
                        } else if (op=='&'){
                            ways+=(isTrue==1)?(x1*x3):(x1*x4)+(x2*x3)+(x2*x4);
                        } else if (op=='|'){
                            ways+=(isTrue==1)?(x1*x3)+(x1*x4)+(x2*x3):(x2*x4);
                        }

                        ways=ways%mod;
                        dp[i][j][isTrue]=(int)ways;
                    }
                }
            }
        }


        return dp[0][n-1][1];
    }



}
