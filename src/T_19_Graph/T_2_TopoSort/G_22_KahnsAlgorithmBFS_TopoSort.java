package src.T_19_Graph.T_2_TopoSort;

import java.util.*;

//https://www.geeksforgeeks.org/problems/topological-sort/1
public class G_22_KahnsAlgorithmBFS_TopoSort {
    public static void main(String[] args) {
        int[][] edges={{2,3},{3,1},{4,1},{4,0},{5,0},{5,2}};
        G_22_KahnsAlgorithmBFS_TopoSort ob=new G_22_KahnsAlgorithmBFS_TopoSort();
        System.out.println(ob.topoSort(6,edges));
    }

    //Topological Sort using BFS
    //TC: O(V+E)
    //SC: O(2N)
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        int[] in_degree=new int[V];
        ArrayList<Integer> list=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for (List<Integer> arr:adj){
            for (int e:arr){
                in_degree[e]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (in_degree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int node= queue.poll();
            list.add(node);

            for (int nei: adj.get(node)){
                in_degree[nei]--;
                if (in_degree[nei]==0){
                    queue.add(nei);
                }
            }

        }


        return list;
    }


}
