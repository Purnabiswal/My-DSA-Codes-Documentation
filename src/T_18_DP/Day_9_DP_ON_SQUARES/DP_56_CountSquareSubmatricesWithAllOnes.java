package src.T_18_DP.Day_9_DP_ON_SQUARES;

//LC_1277
//https://www.naukri.com/code360/problems/count-square-submatrices-with-all-ones_3751502
public class DP_56_CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {


        int[][] mat={
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };

        System.out.println(countSquares(mat));

    }


    //Tabulation
    //TC: O(n*m)
    //SC: O(n*m)
    static public int countSquares(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] dp = new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            if(mat[i][0]==1){
                dp[i][0]=1;
                ans++;
            }
        }
        for(int i=1;i<m;i++){
            if(mat[0][i]==1){
                dp[0][i]=1;
                ans++;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j]!=0){
                    dp[i][j]=Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+1;
                    ans+=dp[i][j];
                }
            }
        }


        return ans;
    }
}
