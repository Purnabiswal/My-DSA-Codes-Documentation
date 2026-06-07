package src.T_19_Graph.T_1_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

//L_130
//https://www.naukri.com/code360/problems/capture-region_1092608
//https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1
public class G_14_SurroundedRegions_ReplaceOsWithXs {
    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];

        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]==0){
                bfs(new int[]{i, 0}, board, vis);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==0){
                bfs(new int[]{i, m-1}, board, vis);
            }
        }

        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && vis[0][j]==0){
                bfs(new int[]{0, j}, board, vis);
            }
            if(board[n-1][j]=='O' && vis[n-1][j]==0){
                bfs(new int[]{n-1, j}, board, vis);
            }
        }

        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }

    }

    public void bfs(int[] sn, char[][] board, int[][] vis){
        Queue<int[]> q=new LinkedList<>();
        q.add(sn);
        int sr=sn[0];
        int sc=sn[1];
        board[sr][sc]='O';
        vis[sr][sc]=1;
        int[] arr={0,-1,0,1,0};
        while(!q.isEmpty()){
            int[] node=q.poll();
            int nr=node[0];
            int nc=node[1];
            for(int i=0;i<4;i++){
                int r=nr+arr[i];
                int c=nc+arr[i+1];
                if(r>=0 && r<board.length && c>=0 && c<board[0].length && vis[r][c]==0 && board[r][c]=='O'){
                    vis[r][c]=1;
                    q.add(new int[]{r, c});
                }
            }
        }
    }

    //DFS version
    //TC: O(N) + O(M) + O(N*M*4) = O(N*M)
    //SC: O(N*M)
    public void solve2(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];

        for(int i=0;i<n;i++){
            dfs(i, 0, board, vis);
            dfs(i, m-1, board, vis);
        }

        for(int j=0;j<m;j++){
            dfs(0, j, board, vis);
            dfs(n-1, j, board, vis);
        }

        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }

    }
    public void dfs(int i, int j, char[][] board, int[][] vis){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || vis[i][j]==1 || board[i][j]=='X'){
            return;
        }
        vis[i][j]=1;

        dfs(i, j-1,  board, vis);
        dfs(i, j+1,  board, vis);
        dfs(i-1, j, board, vis);
        dfs(i+1, j,  board, vis);
    }
}
