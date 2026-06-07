package src.T_19_Graph.T_1_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

//LC_733
//https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
//https://www.naukri.com/code360/problems/flood-fill-algorithm_1089687
public class G_9_FloodFillAlgorithm {
    public static void main(String[] args) {

    }




    //using bfs
    //TC: O(N*M*4)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> queue=new LinkedList<>();
        int n= image.length;
        int m= image[0].length;
        int[][] vis=new int[n][m];

        queue.add(new Pair(sr, sc));
        vis[sr][sc]=1;
        int org_color=image[sr][sc];
        image[sr][sc]=color;

        while (!queue.isEmpty()){
            Pair node = queue.poll();
            int r= node.r;
            int c= node.c;
            f(image, queue, vis, r, c-1, org_color, color);
            f(image, queue, vis, r, c+1, org_color, color);
            f(image, queue, vis, r-1, c, org_color, color);
            f(image, queue, vis, r+1, c, org_color, color);
        }

        return image;
    }

    public void f(int[][] image, Queue<Pair> queue, int[][] vis, int r, int c, int org_color, int color){
        if (r>=0 && r< image.length && c>=0 && c< image[0].length && vis[r][c]==0 && image[r][c]==org_color){
            image[r][c]=color;
            vis[r][c]=1;
            queue.add(new Pair(r, c));
        }
    }

    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r=r;
            this.c=c;
        }
    }


    //Using dfs
    //TC: O(N*M*4)
    //SC: O(N*M) + O(N*M)
    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] vis = new int[n][m];
        int org_color = image[sr][sc];
        dfs(image, vis, sr, sc, org_color, color);
        return image;
    }

    public void dfs(int[][] image, int[][] vis, int r, int c, int org_color, int color) {

        if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && vis[r][c] == 0 && image[r][c] == org_color) {
            image[r][c] = color;
            vis[r][c] = 1;

        } else {
            return;
        }

        dfs(image, vis, r, c - 1, org_color, color);
        dfs(image, vis, r, c + 1, org_color, color);
        dfs(image, vis, r - 1, c, org_color, color);
        dfs(image, vis, r + 1, c, org_color, color);

    }

}
