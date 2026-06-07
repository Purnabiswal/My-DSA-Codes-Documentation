package src.T_19_Graph.T_1_BFS_DFS;

import java.util.ArrayList;
import java.util.List;

//LC_802
//https://www.geeksforgeeks.org/problems/eventual-safe-states/1
public class G_20_FindEventualSafeStatesDFS {
    public static void main(String[] args) {
        int[][] graph={
                {1,2},{2,3},{5},{0},{5},{},{}
        };

        G_20_FindEventualSafeStatesDFS ob=new G_20_FindEventualSafeStatesDFS();

        System.out.println(ob.eventualSafeNodes(graph));

    }

    //Striver way
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        List<Integer> list=new ArrayList<>();
        int n= graph.length;
        int[] vis=new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i]==0){
                dfs2(i, vis, graph);
            }
        }
        for (int i = 0; i < n; i++) {
            if (vis[i]==2){
                list.add(i);
            }
        }

        return list;
    }

    boolean dfs2(int node, int[] vis, int[][] adj){
        vis[node]=1;


        for (int nei:adj[node]){
            if (vis[nei] == 0 && dfs2(nei, vis, adj)){
                return true;
            }else if (vis[nei]==1){
                return true;
            }
        }
        vis[node]=2;


        return false;
    }



    //LC_802
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list=new ArrayList<>();
        int n= graph.length;
        int[] vis=new int[n];
        for (int i = 0; i < n; i++) {
            if(!dfs(i,vis, graph)){
                list.add(i);
            }
        }
        return list;
    }

    boolean dfs(int node, int[] vis, int[][] adj){
        vis[node]=1;


        for (int nei:adj[node]){
            if (vis[nei] == 0 && dfs(nei, vis, adj)){
                return true;
            }else if (vis[nei]==1){
                return true;
            }
        }
        vis[node]=2;

        return false;
    }

}
