package src.T_19_Graph.T_1_BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//LC_785
//https://www.geeksforgeeks.org/problems/bipartite-graph/1
//https://www.naukri.com/code360/problems/bipartite-graph_1062589
public class G_17_BipartiteGraph {
    public static void main(String[] args) {

//        int[][] graph={
//                {1,2,3},{0,2},{0,1,3},{0,2}
//        };

        int[][] graph = {
                {1, 3},   // Neighbors of node 0
                {0, 2},   // Neighbors of node 1
                {1, 3},   // Neighbors of node 2
                {0, 2}    // Neighbors of node 3
        };

        G_17_BipartiteGraph ob=new G_17_BipartiteGraph();
        System.out.println(ob.isBipartite(graph));
    }


    //Leetcode
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        int[] color=new int[n];

        System.out.println(Arrays.toString(color));
        for (int i = 0; i < n; i++) {
            if (color[i]==0){
                bfs(i, color, graph);
            }
        }
        System.out.println(Arrays.toString(color));
        int[] vis=new int[n];
        boolean ans=true;
        for (int i = 0; i < n; i++) {
            if (vis[i]==0){
                ans=ans && isBipartite(i, color, vis, graph);
            }
        }
        System.out.println(Arrays.toString(color));
        return ans;
    }

    void bfs(int sn, int[] color, int[][] graph){
        Queue<Integer> queue=new LinkedList<>();

        queue.add(sn);
        color[sn]=1;
        while (!queue.isEmpty()){
            int node= queue.poll();
            int e=(color[node]==1)?2:1;
            for (int nei:graph[node]){
                if (color[nei]==0){ //if unvisited
                    color[nei]=e; //then visit
                    queue.add(nei);
                }
            }

        }
    }


    boolean isBipartite(int sn, int[] color, int[] vis, int[][] graph){
        Queue<Integer> queue=new LinkedList<>();

        queue.add(sn);
        color[sn]=1;
        while (!queue.isEmpty()){
            int node= queue.poll();
            int e=color[node];
            for (int nei:graph[node]){
                if (color[nei]==e){ //if same color
                    return false;
                }else if (vis[nei]==0){ //if unvisited
                    vis[nei]=1; //visit it
                    queue.add(nei);
                }
            }

        }

        return true;
    }









    //Leetcode shorter one
    //Note - try out this problem using dfs
    public boolean isBipartite2(int[][] graph) {
        int n= graph.length;
        int[] color=new int[n];
        boolean ans=true;

        for (int i = 0; i < n; i++) {
            if (color[i]==0){
                ans=ans && bfs2(i, color, graph);
            }
        }

        return ans;
    }
    boolean bfs2(int sn, int[] color, int[][] graph){
        Queue<Integer> queue=new LinkedList<>();

        queue.add(sn);
        color[sn]=1;
        while (!queue.isEmpty()){
            int node= queue.poll();
            int e=(color[node]==1)?2:1;
            int e2=color[node];
            for (int nei:graph[node]){
                if (color[nei]!=0 && color[nei]==e2){
                    return false;
                }else if (color[nei]==0){
                    color[nei]=e;
                    queue.add(nei);
                }
            }

        }
        return true;
    }




    //GFG
    public boolean isBipartite3(int V, int[][] edges) {
        int[][] graph=findAdj3(V, edges);
        int n= graph.length;
        int[] color=new int[n];
        boolean ans=true;

        for (int i = 0; i < n; i++) {
            if (color[i]==0){
                ans=ans && bfs3(i, color, graph);
            }
        }

        return ans;
    }

    boolean bfs3(int sn, int[] color, int[][] graph){
        Queue<Integer> queue=new LinkedList<>();

        queue.add(sn);
        color[sn]=1;
        while (!queue.isEmpty()){
            int node= queue.poll();
            int e=(color[node]==1)?2:1;
            int e2=color[node];
            for (int nei:graph[node]){
                if (color[nei]!=0 && color[nei]==e2){
                    return false;
                }else if (color[nei]==0){
                    color[nei]=e;
                    queue.add(nei);
                }
            }

        }
        return true;
    }
    public int[][] findAdj3(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        int[][] graph = new int[V][];
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> neighbors = adj.get(i);
            graph[i] = new int[neighbors.size()];
            for (int j = 0; j < neighbors.size(); j++) {
                graph[i][j] = neighbors.get(j);
            }
        }

        return graph;
    }



}
