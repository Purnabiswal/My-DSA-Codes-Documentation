package src.T_19_Graph.T_1_BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
public class G_5_BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list;
    }


    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int v=adj.size();
        int[] vis=new int[v];
        Queue<Integer> queue=new LinkedList<>();

        queue.add(0); //add first guy to queue
        vis[0]=1;

        ArrayList<Integer> bfs=new ArrayList<>();

        while (!queue.isEmpty()){
            int node=queue.poll();
            System.out.println(node);
            bfs.add(node);

            for (Integer it : adj.get(node)){ //check for neighbors for cur node
                if (vis[it]==0){
                    vis[it]=1;
                    queue.add(it);
                }
            }

        }

        return bfs;
    }

}
