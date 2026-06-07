package src.T_19_Graph.T_2_TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G_23_DetectCycleInDirectedGraphBFS {
    public static void main(String[] args) {

    }

    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        int[] in_degree=new int[V];
        Queue<Integer> queue=new LinkedList<>();
        for (List<Integer> arr:adj){
            for (int e:arr){
                in_degree[e]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (in_degree[i]==0){
                queue.add(i);
            }
        }
        int ans=0;
        while (!queue.isEmpty()){
            int node= queue.poll();
            ans++;

            for (int nei: adj.get(node)){
                in_degree[nei]--;
                if (in_degree[nei]==0){
                    queue.add(nei);
                }
            }

        }


        return ans!=V;
    }


}
