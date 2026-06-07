package src.T_19_Graph.T_1_BFS_DFS;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

public class G_12_DetectCycleInUndirectedGraphUsingDFS {
    public static void main(String[] args) {

    }


    //TC: O(N+2*E) + O(N)
    //SC: O(N)+O(N) = O(N)
    public boolean isCycle(int V, int[][] edges) {
        int[] vis=new int[V];
        ArrayList<ArrayList<Integer>> adj=findAdj(V, edges);
//        for (ArrayList<Integer> q:adj){
//            System.out.print(q);
//        }

        for (int i = 0; i < V; i++) {
            if (vis[i]==0){
                if (dfsCycle(i, -1, vis, adj)){
                    return true;
                }
            }
        }


        return false;
    }
    public boolean dfsCycle(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;

        for(Integer nei:adj.get(node)){
            if(vis[nei]==0){
                if(dfsCycle(nei, node, vis, adj)){
                    return true;
                }
            }else if(nei!=parent){
                return true;
            }
        }

        return false;
    }
    // search for neighbors
    public ArrayList<ArrayList<Integer>> findAdj(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i< V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        return adj;
    }


}
