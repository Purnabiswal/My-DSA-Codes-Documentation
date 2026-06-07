package src.T_19_Graph.T_1_BFS_DFS;

import java.util.*;

//https://leetcode.com/problems/course-schedule/description/
//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
//https://www.naukri.com/code360/problems/detect-cycle-in-a-undirected-graph_626071
public class G_11_DetectCycleInUndirectedGraphUsingBFS {
    public static void main(String[] args) {
        int[][] edges={
                {0, 4},
                {1, 2},
                {1, 4},
                {2, 3},
                {3, 4},
        };
        int V=5;
        G_11_DetectCycleInUndirectedGraphUsingBFS ob=new G_11_DetectCycleInUndirectedGraphUsingBFS();
//        System.out.println(ob.isCycle(V, edges));


        int[][] p={
                {1,4},
                {2,4},
                {3,1},
                {3,2}
        };

        System.out.println(ob.canFinish(5, p));






    }


    //GFG one
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
                if (bfsCycle(i, vis, adj)){
                    return true;
                }
            }
        }


        return false;
    }

    public boolean bfsCycle(int st_node, int[] vis, ArrayList<ArrayList<Integer>> adj){

        Queue<int[]> queue=new LinkedList<>();


        queue.add(new int[]{st_node, -1});
        vis[st_node]=1;

        while (!queue.isEmpty()){
            int[] cur= queue.poll();
            int node=cur[0];
            int parent=cur[1];
            //search for neighbours
            for (int e: adj.get(node)){
                if (vis[e]==0){
                    queue.add(new int[]{e, node});
                    vis[e]=1;
                }else if (e!=parent){
                    return true;
                }
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






    //Leetcode one
    //wrong code
    public boolean canFinish(int V, int[][] prerequisites) {
        int[] vis=new int[V];
        ArrayList<ArrayList<Integer>> adj=findAdj2(V, prerequisites);

        for (ArrayList<Integer> e:adj){
            System.out.print(e+", ");
        }
        System.out.println();

        for (int i = 0; i < V; i++) {
            if (vis[i]==0){
                if (bfsCycle2(i, vis, adj)){
                    return false;
                }
            }
        }


        return true;
    }

    public boolean bfsCycle2(int st_node, int[] vis, ArrayList<ArrayList<Integer>> adj){

        Queue<int[]> queue=new LinkedList<>();


        queue.add(new int[]{st_node, -1});
        vis[st_node]=1;

        while (!queue.isEmpty()){
            int[] cur= queue.poll();
            int node=cur[0];
            int parent=cur[1];
            //search for neighbours
            for (int e: adj.get(node)){
                if (vis[e]==1 && e!=parent){
                    return true;
                } else if (vis[e]==0){
                    queue.add(new int[]{e, node});
                    vis[e]=1;
                }
            }
        }

        return false;
    }

    // search for neighbors
    public ArrayList<ArrayList<Integer>> findAdj2(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i< V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            adj.get(arr[0]).add(arr[1]);
        }
        return adj;
    }


}
