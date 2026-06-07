package src.T_19_Graph.T_1_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

//LC_994
//https://www.naukri.com/code360/problems/rotting-oranges_701655
//https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
public class G_10_RottenOranges {
    public static void main(String[] args) {
        int[][] grid={
                {2,1,2,1,2},
                {2,1,2,2,1},
                {0,1,2,0,1},
                {1,1,1,1,1},
                {2,2,2,2,2}
        };

        System.out.println(orangesRotting(grid));
    }

    //TC: O(N*M) + O(N*M*4)
    //TC: O(N*M)
    //Note- Try not to alter given grid. Below code alters given grid you can create a visited array and do the same stuff on that instead of given grid.
    static public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        Pair intv1=null;
        Pair intv2=null;
        int countOne=0;
        Queue<Pair> queue=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==2){
                    Pair e=new Pair(i, j);
                    queue.add(e);
                    intv1=e;
                }else if(grid[i][j]==1){
                    countOne++;
                }
            }
        }
        int ans=0;
        int[] arr={0,-1,0,1,0};
        while (!queue.isEmpty()){
            Pair node= queue.poll();
            int i=0;
            int j=1;
            //search for neighbours
            while (i<arr.length-1 && j<arr.length){
                int r = node.r+arr[i];
                int c = node.c+arr[j];
                if (r>=0 && r<n && c>=0 && c<m && grid[r][c]==1){
                    grid[r][c]=2; //rotting
                    Pair pair=new Pair(r, c);
                    intv2=pair;
                    queue.add(pair);
                    countOne--;
                }
                i++;
                j++;
            }

            if (!queue.isEmpty() && intv2 != null && node.r == intv1.r && node.c == intv1.c){
                intv1=intv2;
                ans++;
            }

        }

        if(countOne!=0) return -1;

        return ans;
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
