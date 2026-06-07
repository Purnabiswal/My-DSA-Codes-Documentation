package src.T_19_Graph.T_1_BFS_DFS;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-distinct-islands-ii/description/
//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
//https://www.naukri.com/code360/problems/distinct-island_630460
public class G_16_NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid={
                {1,1,0,0,1},
                {1,0,0,1,1},
                {0,0,1,0,0},
                {0,1,1,0,0},
                {0,0,0,1,1}
        };
//        int[][] grid={
//                {1,0,1,0,1},
//        };

        G_16_NumberOfDistinctIslands ob=new G_16_NumberOfDistinctIslands();
        System.out.println(ob.countDistinctIslands(grid));

//        int n= grid.length;
//        int m= grid[0].length;
//        int[][] vis=new int[n][m];
//        System.out.println(ob.isIdentical(0,4,0,0,0,-4, 2, grid, vis));
//        System.out.println(ob.checkIdentical(0,4,0,0,0,-4, 1, grid, vis));
    }

    //gfg one
    //TC: O(N*M*log(n*m)) + O(N*M*4) = O(N*M*log(n*m))
    //SC: O(N*M) + O(N*M) = O(N*M)
    int countDistinctIslands(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int[][] vis=new int[n][m];
        Set<String> set=new HashSet<>();
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]==0 && grid[i][j]==1){
                    String s="";
                    s=dfs(i, j, i, j, grid, vis);
//                    System.out.println(set.contains(s)+ " s: "+s);
                    if (!set.contains(s)){
                        ans++;
                        set.add(s); //log(n*m) to insert an element to set
                    }
//                  System.out.println(set.contains(s));
                }
            }
        }

        return ans;
    }



    String dfs(int i, int j, int bi, int bj, int[][] grid, int[][] vis){
        if (i<0 || i>= grid.length || j<0 || j>= grid[0].length || vis[i][j]!=0 || grid[i][j]==0){
            return "";
        }
        String s= (i - bi) +""+ (j-bj)+",";

        vis[i][j]=1;
        s+=dfs(i, j-1,  bi, bj, grid, vis);
        s+=dfs(i, j+1,  bi, bj, grid, vis);
        s+=dfs(i-1, j, bi, bj, grid, vis);
        s+=dfs(i+1, j,  bi, bj, grid, vis);

        return s;
    }





}
