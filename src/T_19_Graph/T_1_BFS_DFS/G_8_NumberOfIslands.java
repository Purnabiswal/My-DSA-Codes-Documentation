package src.T_19_Graph.T_1_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

//LC_200
//https://www.geeksforgeeks.org/problems/number-of-islands/1
//https://www.naukri.com/code360/problems/number-of-islands_985348
public class G_8_NumberOfIslands {
    public static void main(String[] args) {


//        char[][] mat={
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };

        char[][] mat = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(mat));



//        ArrayList<ArrayList<Integer>> vis=new ArrayList<>(10);
//        ArrayList<Integer> e=new ArrayList<>();
//        e.add(1,1);
//        vis.add(1,e);
//
//        System.out.println(vis);

    }


    //Try- https://leetcode.com/problems/count-the-number-of-complete-components/description/

    //TC: O(N*M*9) + O(N)
    //SC: O(N*M) + O(N*M)
    static public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis=new int[n][m];


        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]==0 && grid[i][j]=='1'){
                    Pair st_node=new Pair(i, j);
                    bfs(st_node, vis, grid);
//                System.out.println(i+" "+Arrays.toString(vis));
                    ans++;
                }
            }
        }

        return ans;
    }

    static public void bfs(Pair st_node, int[][] vis, char[][] grid) {
        Queue<Pair> queue=new LinkedList<>();
        queue.add(st_node); //add starting node / guy to queue
        vis[st_node.r][st_node.c]=1;

        while (!queue.isEmpty()){
            Pair node = queue.poll();
            int n = node.r;
            int m = node.c;

            //traversing neighbors
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == j || i == -j) continue; //no need to continue for gfg problem
                    int r = n + i;
                    int c = m + j;
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length
                            && vis[r][c] == 0 && grid[r][c] == '1') {
                        vis[r][c] = 1;
                        queue.add(new Pair(r, c));
                    }
                }
            }

        }


    }
    static class Pair{
        int r;
        int c;

        Pair(int r, int c){
            this.r=r;
            this.c=c;
        }
    }



}


