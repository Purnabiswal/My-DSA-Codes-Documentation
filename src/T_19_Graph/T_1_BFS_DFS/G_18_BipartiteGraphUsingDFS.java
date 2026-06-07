package src.T_19_Graph.T_1_BFS_DFS;

public class G_18_BipartiteGraphUsingDFS {
    public static void main(String[] args) {

        int[][] graph = {
                {1, 3},   // Neighbors of node 0
                {0, 2},   // Neighbors of node 1
                {1, 3},   // Neighbors of node 2
                {0, 2}    // Neighbors of node 3
        };

        G_18_BipartiteGraphUsingDFS ob=new G_18_BipartiteGraphUsingDFS();
        System.out.println(ob.isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        int[] color=new int[n];
        boolean ans=true;

        for (int i = 0; i < n; i++) {
            if (color[i]==0){
                ans=ans && dfs(i, -1,1, color, graph);
            }
        }

        return ans;
    }

    boolean dfs(int node, int cur_node, int to_color, int[] color, int[][] graph){
        int cur_color=color[node];
        if (cur_color==cur_node) return false;
        if (cur_color!=0) return true;
        boolean ans=true;
        color[node]=to_color;
        int next_color=(to_color==1)?2:1;
        for (int nei:graph[node]){
            ans=ans && dfs(nei, to_color, next_color, color, graph);
        }

        return ans;
    }


}
