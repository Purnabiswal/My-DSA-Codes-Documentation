package src.T_19_Graph.T_2_TopoSort;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LC_207
//LC_210
public class G_24_CourseSchedule_1And2BFS {
    public static void main(String[] args) {

    }

    //CourseSchedule_1And2 using BFS
    //LC_207
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] in_degree=new int[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        for (List<Integer> arr:adj){
            for (int e:arr){
                in_degree[e]++;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (in_degree[i]==0){
                queue.add(i);
            }
        }
        int ans=0;
        while (!queue.isEmpty()){
            int node= queue.poll();
            ans++;

            for (int nei: adj.get(node)){
                in_degree[nei]--;
                if (in_degree[nei]==0){
                    queue.add(nei);
                }
            }

        }


        return ans==numCourses;
    }


    //LC_210
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] in_degree=new int[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        for (List<Integer> arr:adj){
            for (int e:arr){
                in_degree[e]++;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (in_degree[i]==0){
                queue.add(i);
            }
        }

        int[] order=new int[numCourses];
        int i=0;
        while (!queue.isEmpty()){
            int node= queue.poll();
            order[i++]=node;
            for (int nei: adj.get(node)){
                in_degree[nei]--;
                if (in_degree[nei]==0){
                    queue.add(nei);
                }
            }

        }

        if (i==numCourses){
            return order;
        }

        return new int[]{};
    }


}
