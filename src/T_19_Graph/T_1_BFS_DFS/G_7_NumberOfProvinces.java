package src.T_19_Graph.T_1_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

//LC_547
//https://www.geeksforgeeks.org/problems/number-of-provinces/1
//https://www.naukri.com/code360/problems/find-the-number-of-states_1377943
public class G_7_NumberOfProvinces {
    public static void main(String[] args) {

//        int[][] mat={
//                {1,1,0},
//                {1,1,0},
//                {0,0,1}
//        };
//        int[][] mat={
//                {1,0,0},
//                {0,1,0},
//                {0,0,1}
//        };
        int[][] mat={
                {1,0},
                {0,1}
        };
        System.out.println(findCircleNum(mat));
    }


    static public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int[] vis=new int[n];

        int ans=0;
        for (int i = 0; i < n; i++) {
            if (vis[i]==0){
//                bfs(i, vis, isConnected);
                dfs(i, vis, isConnected);
//                System.out.println(i+" "+Arrays.toString(vis));
                ans++;
            }
        }

        return ans;
    }
    static public void bfs(int st_node, int[] vis, int[][] mat) {

        Queue<Integer> queue=new LinkedList<>();

        queue.add(st_node); //add starting node / guy to queue
        vis[st_node]=1;


        while (!queue.isEmpty()){
            int node=queue.poll();
            int[] arr=mat[node];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]==1 && vis[i]==0){
                    vis[i]=1;
                    queue.add(i);
                }
            }

        }
    }


    static public void dfs(int node, int[] vis, int[][] adj) {
        vis[node]=1;

        for (int i = 0; i < adj.length; i++) {
            if(adj[node][i]==1 && vis[i]==0){
                dfs(i, vis, adj);
            }
        }
    }

}
