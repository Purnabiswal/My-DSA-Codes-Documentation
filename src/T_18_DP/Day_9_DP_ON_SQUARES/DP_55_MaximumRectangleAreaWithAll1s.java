package src.T_18_DP.Day_9_DP_ON_SQUARES;

import java.util.Stack;

//LC_85
//https://www.naukri.com/code360/problems/maximum-size-rectangle-sub-matrix-with-all-1-s_893017
public class DP_55_MaximumRectangleAreaWithAll1s {
    public static void main(String[] args) {

        char[][] mat={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };

        System.out.println(maximalRectangle(mat));
    }


    //Try out - Largest Rectangle in a Histogram




    //TC: O(n*(m+m)) or O(n*m)
    //SC: O(n)
    static public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[] arr=new int[m];

        int maxArea=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char cur=matrix[i][j];
                if (cur=='0'){
                    arr[j]=0;
                }else {
                    arr[j]+=1;
                }
            }
            maxArea=Math.max(maxArea, largestRectangleArea(arr));
        }

        return maxArea;
    }

    static public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea =0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek()!=-1 && heights[i]<heights[stack.peek()]){
                int height=heights[stack.pop()];
                int width=i-stack.peek()-1;
                maxArea=Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        //maxArea=Math.max(maxArea, arr[stack.pop()]*(nse-pse-1)); //nse=i, pse=stack.peek()
        while (stack.peek()!=-1){
            int height=heights[stack.pop()];
            int width=heights.length-1-stack.peek();
            maxArea=Math.max(maxArea, height*width);
        }
        return maxArea;
    }




}
