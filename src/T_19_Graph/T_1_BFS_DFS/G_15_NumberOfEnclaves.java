package src.T_19_Graph.T_1_BFS_DFS;

//LC_1020
//https://www.geeksforgeeks.org/problems/number-of-enclaves/1
public class G_15_NumberOfEnclaves {
    public static void main(String[] args) {

    }

    //TC: O(N) + O(M) + O(N*M*4) = O(N*M)
    //SC: O(N*M)
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];

        for(int i=0;i<n;i++){
            dfs(i, 0, grid, vis);
            dfs(i, m-1, grid, vis);
        }

        for(int j=0;j<m;j++){
            dfs(0, j, grid, vis);
            dfs(n-1, j, grid, vis);
        }

        int count=0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
    //You can use bfs also
    public void dfs(int i, int j, int[][] grid, int[][] vis){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j]==1 || grid[i][j]==0){
            return;
        }
        vis[i][j]=1;

        dfs(i, j-1,  grid, vis);
        dfs(i, j+1,  grid, vis);
        dfs(i-1, j, grid, vis);
        dfs(i+1, j,  grid, vis);
    }
}
