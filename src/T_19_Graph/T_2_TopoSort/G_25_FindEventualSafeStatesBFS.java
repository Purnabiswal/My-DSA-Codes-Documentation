package src.T_19_Graph.T_2_TopoSort;

import java.util.*;

//LC_802
//https://www.geeksforgeeks.org/problems/eventual-safe-states/1
public class G_25_FindEventualSafeStatesBFS {
    public static void main(String[] args) {

    }


    //TC: O(V+E) + O(nlog(n)) [for extra sorting]
    //SC: O(2N) + space for reverse graph
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n= graph.length;

        List<List<Integer>> reversedGraph=new ArrayList<>(); //adj of reversed graph

        int[] in_degree=new int[n];
        ArrayList<Integer> list=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();

        for (int i = 0; i < n; i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                reversedGraph.get(graph[i][j]).add(i);
                in_degree[i]++;
            }
        }


        for (int i = 0; i < n; i++) {
            if (in_degree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int node= queue.poll();
            list.add(node);

            for (int nei: reversedGraph.get(node)){
                in_degree[nei]--;
                if (in_degree[nei]==0){
                    queue.add(nei);
                }
            }

        }

        Collections.sort(list);
        return list;
    }

}
