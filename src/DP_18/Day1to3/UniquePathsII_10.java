package src.DP_18.Day1to3;


import java.util.Arrays;

//63. Unique Paths II
public class UniquePathsII_10 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,0,0},
                {0,1,0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));
        System.out.println(uniquePathsWithObstacles3(obstacleGrid));
        System.out.println(uniquePathsWithObstacles4(obstacleGrid));
    }


    //Recursion
    //TC: O(2^(M*N))
    //SC: O((N-1)+(M-1))
    static public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        return f(m-1, n-1, obstacleGrid);
    }
    static public int f(int m, int n, int[][] obstacleGrid) {
        //check for obstacles
        if (obstacleGrid[m][n]==1){
            return 0;
        }
        if (m==0 && n==0){
            return 1;
        }


        int left=0;
        int up=0;
        if (n!=0){
            left=f(m, n-1, obstacleGrid);
        }
        if (m!=0){
            up=f(m-1, n, obstacleGrid);
        }

        return left+up;
    }

    //Memoization
    //TC: O(M*N)
    //SC: O((N-1)+(M-1)) + O(M*N)
    static public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return f2(m-1, n-1, obstacleGrid, dp);
    }
    static public int f2(int m, int n, int[][] obstacleGrid, int[][] dp) {
        //check for obstacles
        if (obstacleGrid[m][n]==1){
            return 0;
        }
        //base case
        if (m==0 && n==0){
            return 1;
        }

        if (dp[m][n]!=-1){
            return dp[m][n];
        }
        int left=0;
        int up=0;
        if (n!=0){
            left=f2(m, n-1, obstacleGrid, dp);
        }
        if (m!=0){
            up=f2(m-1, n, obstacleGrid, dp);
        }

        return dp[m][n] = left + up;
    }

    //Tabulation
    //TC: O(M*N)
    //SC: O(M*N)
    static public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                } else if (i==0 && j==0){
                    dp[0][0]=1;
                } else {
                    int left = 0;
                    int up = 0;
                    if (j>0){
                        left = dp[i][j-1];
                    }
                    if (i>0){
                        up = dp[i-1][j];
                    }
                    dp[i][j]=left+up;
                }
            }
        }

        return dp[m-1][n-1];
    }

    //Tabulation
    //TC: O(M*N)
    //SC: O(M*N)
    static public int uniquePathsWithObstacles4(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        int prev=0;

        for (int i = 0; i < m; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j]==1){
                    cur[j]=0;
                } else if (i==0 && j==0){
                    cur[0]=1;
                } else {
                    int left = 0;
                    int up = 0;
                    if (j>0){
                        left = prev;
                    }
                    if (i>0){
                        up = dp[j];
                    }
                    cur[j]=left+up;
                }
                prev=cur[j];
            }
            dp=cur;
        }
        return dp[n-1];
    }
}
