package src.T_19_Graph.T_3_ShortestPathAlgorithmsAndProblems;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
//https://www.naukri.com/code360/problems/shortest-path-in-an-unweighted-graph_981297 -slightly different
//https://leetcode.com/problems/shortest-path-visiting-all-nodes/  -slightly different

import java.util.*;

public class G_28_ShortestPathInUndirectedGraphWithUnitWeights {
    public static void main(String[] args) {

        int[][] edges={{1,3}, {3,0}};
        System.out.println(Arrays.toString(shortestPath(4, edges, 3)));

    }

    //gfg one
    static public int[] shortestPath(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> queue=new LinkedList<>();


        int[] dist=new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src]=0;
        queue.add(src);

        //TC: O(V+E)
        while (!queue.isEmpty()){
            int node=queue.poll();
            int node_w=dist[node];
            for (int nei: adj.get(node)){
                int w=node_w+1;
                if (w<dist[nei]){
                    dist[nei]=w;
                    queue.add(nei);
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





}
