package src.T_19_Graph.T_1_BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;

//LC_207
//LC_210
//https://www.naukri.com/code360/problems/detect-cycle-in-a-directed-graph_1062626
//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class G_19_DetectCycleInDirectedGraph {
    public static void main(String[] args) {

//        int[][] a={{0, 1}, {1, 0}};
        int[][] a={ {1, 0}, {2,0},{3,1},{3,2}};
//        int[][] a={{1, 0}};
        G_19_DetectCycleInDirectedGraph ob=new G_19_DetectCycleInDirectedGraph();
//        System.out.println(ob.canFinish(2, a));
        ob.findOrder(4, a);


    }


    //LC_207
    //TC: O(V+E)
    //SC: O(2N)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj=findAdj(numCourses, prerequisites);

        int[] pathVis=new int[numCourses];

        int[] vis=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (vis[i]==0){
                if (dfs(i, vis, pathVis, adj)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int node, int[] vis, int[] pathVis, ArrayList<Integer>[] adj){
        pathVis[node]=1;
        vis[node]=1;
        for (int nei:adj[node]){
            if (vis[nei]==0 && dfs(nei, vis, pathVis, adj)) {
                return true;
            }else if(pathVis[nei]==1) {
                return true;
            }
        }
        pathVis[node]=0;
        return false;
    }

    ArrayList<Integer>[] findAdj(int n, int[][] prerequisites){
        ArrayList<Integer>[] adj=new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i]=new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        return adj;
    }



    //LC_210
    //https://leetcode.com/problems/course-schedule-ii/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] vis=new int[numCourses];
        int[] pathVis=new int[numCourses];
        ArrayList<Integer> courseOrder=new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (vis[i]==0){
                if (dfs2(i, vis, pathVis, adj, courseOrder)){
                    return new int[]{};
                }
            }
        }

        int[] ans=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i]=courseOrder.get(numCourses-i-1);
        }


        return ans;
    }

    boolean dfs2(int node, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> courseOrder){
        vis[node]=1;
        pathVis[node]=1;


        for (int nei:adj.get(node)){
            if (vis[nei] == 0 && dfs2(nei, vis, pathVis, adj, courseOrder)){
                return true;
            }else if (pathVis[nei]==1){
                return true;
            }
        }
        pathVis[node]=0;
        courseOrder.add(node);
        return false;
    }


    //LC_210
    //https://leetcode.com/problems/course-schedule-ii/
    //Without patVis
    public int[] findOrder3(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] vis=new int[numCourses];
        ArrayList<Integer> courseOrder=new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (vis[i]==0){
                if (dfs3(i, vis, adj, courseOrder)){
                    return new int[]{};
                }
            }
        }

        int[] ans=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i]=courseOrder.get(numCourses-i-1);
        }


        return ans;
    }

    boolean dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> courseOrder){
        vis[node]=1;

        for (int nei:adj.get(node)){
            if (vis[nei] == 0 && dfs3(nei, vis, adj, courseOrder)){
                return true;
            }else if (vis[nei]==1){
                return true;
            }
        }

        vis[node]=2;
        courseOrder.add(node);
        return false;
    }




    //GFG
    //No as such change
    public boolean isCyclic4(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=findAdj4(V, prerequisites);
        int[] dp=new int[V];
        Arrays.fill(dp, -1);
        boolean ans=true;
        int[] vis=new int[V];
        for (int i = 0; i < V; i++) {
            ans=ans && dfs4(i, vis, adj, dp);
        }
        return !ans;
    }

    boolean dfs4(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, int[] dp){
        if (dp[node]!=-1){
            return dp[node] != 0;
        }
        vis[node]=1;
        boolean ans=true;
        for (int nei:adj.get(node)){
            if (vis[nei]!=0) {
                return false;
            }else {
                ans = ans && dfs4(nei, vis, adj, dp);
            }
        }
        vis[node]=0;
        dp[node]=(!ans)?0:1;
        return ans;
    }

    ArrayList<ArrayList<Integer>> findAdj4(int n, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        return adj;
    }


}
