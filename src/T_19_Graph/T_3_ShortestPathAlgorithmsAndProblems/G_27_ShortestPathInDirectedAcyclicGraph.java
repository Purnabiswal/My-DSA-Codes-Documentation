package src.T_19_Graph.T_3_ShortestPathAlgorithmsAndProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
//https://www.naukri.com/code360/problems/shortest-path-in-dag_8381897
//
public class G_27_ShortestPathInDirectedAcyclicGraph {
    public static void main(String[] args) {

    }

    static class Pair{
        int v;
        int w;
        Pair(int v, int w){
            this.v=v;
            this.w=w;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        //TC: O(V+E)
        Stack<Integer> stack=new Stack<>();
        int[] vis=new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i]==0){
                topoSort(i, vis, stack, adj);
            }
        }

        int[] dist=new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[0]=0;

        //TC: O(V+E)
        while (!stack.isEmpty()){
            int node=stack.pop();
            int node_w=dist[node];
            for (Pair pair: adj.get(node)){
                int nei=pair.v;
                int w=node_w+pair.w;
                if (w<dist[nei]){
                    dist[nei]=w;
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i]==(int) 1e9){
                dist[i]=-1;
            }
        }

        return dist;
    }

    void topoSort(int node, int[] vis, Stack<Integer> stack, ArrayList<ArrayList<Pair>> adj){
        vis[node]=1;

        for (Pair pair:adj.get(node)){
            int nei=pair.v;
            if (vis[nei]==0){
                topoSort(nei, vis, stack, adj);
            }
        }

        stack.push(node);
    }
}
