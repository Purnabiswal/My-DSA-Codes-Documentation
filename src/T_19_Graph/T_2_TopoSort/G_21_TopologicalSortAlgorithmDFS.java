package src.T_19_Graph.T_2_TopoSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/topological-sort/1
//https://www.naukri.com/code360/problems/topological-sort_985252
public class G_21_TopologicalSortAlgorithmDFS {
    public static void main(String[] args) {




    }

    //TC: O(V+E) [as it is a directed graph]
    //SC: O(n)+O(n)
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        int[] vis=new int[V];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i]==0){
                dfs(i, vis, adj, stack);
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }

        return list;
    }

    void dfs(int node, int[] vis, List<List<Integer>> adj, Stack<Integer> stack){
        vis[node]=1;

        for (int nei:adj.get(node)){
            if (vis[nei]==0){
                dfs(nei, vis, adj, stack);
            }
        }

        stack.push(node);
    }


}
