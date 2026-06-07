package src.T_18_DP.Day_8_MCM_DP;


public class DP_49_MCM_Tabulation {
    public static void main(String[] args) {
//        int[] a={10,20,30,40,50};
//        int[] a={4,5,3,2};
        int[] a={40, 29 ,32 ,33 ,44 ,33, 20, 42,45 ,26, 40, 30, 34, 23, 34 ,42, 35 ,40, 25, 32 };
        System.out.println(mcm(a, a.length));
        System.out.println(mcm2(a, a.length));
    }


    //Tabulation
    //Clear one
    //TC: O(n*n*n) nearly O(n^3)
    //SC: O(n*n)
    public static int mcm2(int[] a , int n) {
        int[][] dp=new int[n][n];

        for (int i = n-1; i >= 1; i--) {
            for (int j = i+1; j <= n-1; j++) {
                int steps, min=(int) 1e9;
                for (int k = i; k < j; k++) {
                    steps=a[i-1]*a[k]*a[j]+dp[i][k]+dp[k+1][j];
                    min=Math.min(min, steps);
                }
                dp[i][j]=min;
            }
        }

        return dp[1][n-1];
    }




    //Tabulation
    //TC: O(n*n*n) nearly O(n^3)
    //SC: O(n*n)
    public static int mcm(int[] a , int n) {
        int[][] dp=new int[n][n];

        for (int i = n-1; i >= 1; i--) {
            for (int j = i+1; j <= n-1; j++) {
                if (i==j){
                    dp[i][j]=0;
                }else {
                    int steps, min=(int) 1e9;
                    for (int k = i; k < j; k++) {
                        steps=a[i-1]*a[k]*a[j]+dp[i][k]+dp[k+1][j];
                        min=Math.min(min, steps);
                    }
                    dp[i][j]=min;
                }
            }
        }

        return dp[1][n-1];
    }






}
