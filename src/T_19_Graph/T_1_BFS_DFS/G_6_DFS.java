package src.T_19_Graph.T_1_BFS_DFS;

import java.util.ArrayList;

public class G_6_DFS {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int v=adj.size();
        int[] vis=new int[v];
        vis[0]=1;
        ArrayList<Integer> list=new ArrayList<>();
        dfs(0, vis, list, adj);
        return list;
    }
    public void dfs(int node, int[] vis, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> adj) {
        vis[node]=1;

        list.add(node);

        for(Integer it:adj.get(node)){// for every neighbour of the current node
            if(vis[it]==0){
                dfs(it, vis, list, adj);
            }
        }
    }
}
