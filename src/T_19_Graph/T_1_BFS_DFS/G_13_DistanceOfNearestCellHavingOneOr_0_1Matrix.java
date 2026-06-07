package src.T_19_Graph.T_1_BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//LC_542
//https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
public class G_13_DistanceOfNearestCellHavingOneOr_0_1Matrix {
    public static void main(String[] args) {

    }


    //Leetcode one
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue=new LinkedList<>();
        int n= mat.length;;
        int m= mat[0].length;;
        int[][] vis=new int[n][m];
        int[][] ans=new int[n][m];
        //Having multiple starting nodes
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]==0){
                    queue.add(new int[]{i, j});
                    ans[i][j]=0;//no need
                    vis[i][j]=1;
                }
            }
        }

        int[] arr={0,-1,0,1,0};
        while (!queue.isEmpty()){

            int[] node=queue.poll();

            int i=node[0];
            int j=node[1];
            int k=0;
            while (k<4){
                int x=i+arr[k];
                int y=j+arr[k+1];
                if (x>=0 && x<n && y>=0 && y<m && vis[x][y]==0){
                    ans[x][y]=ans[i][j]+1;
                    queue.add(new int[]{x, y});
                    vis[x][y]=1;
                }
                k++;
            }

        }


        return ans;
    }


    //gfg one
    //Use .set to replace an element in arraylist
    /*
        add(index, value)	Inserts element	Shifts existing elements to the right	list.add(0, 5) → [5]
        set(index, value)	Replaces element	Updates existing element at index	list.set(0, 10) → [10]
    */
    public ArrayList<ArrayList<Integer>> nearest(int[][] mat) {
        Queue<int[]> queue=new LinkedList<>();
        int n= mat.length;;
        int m= mat[0].length;;
        int[][] vis=new int[n][m];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> row=new ArrayList<>();
            for(int j=0;j<m;j++){
                row.add(0);
            }
            ans.add(row);
        }
        //Having multiple starting nodes
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]==1){
                    queue.add(new int[]{i, j});
                    ans.get(i).set(j, 0);//no need
                    vis[i][j]=1;
                }
            }
        }

        int[] arr={0,-1,0,1,0};
        while (!queue.isEmpty()){

            int[] node=queue.poll();

            int i=node[0];
            int j=node[1];
            int k=0;
            while (k<4){
                int x=i+arr[k];
                int y=j+arr[k+1];
                if (x>=0 && x<n && y>=0 && y<m && vis[x][y]==0){
                    ans.get(x).set(y, ans.get(i).get(j)+1);
                    queue.add(new int[]{x, y});
                    vis[x][y]=1;
                }
                k++;
            }

        }


        return ans;

    }

}
