package src.StackAndQueue_12.Questions;

import java.util.Stack;

public class LargestRectangleOfHistogram_LC84 {
    public static void main(String[] args) {
        int[] arr={1,3,6};
        System.out.println(largestRectangleArea(arr));
    }


    //Efficient
    static public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea =0;
        for (int i = 0; i < heights.length; i++) {
           while (stack.peek()!=-1 && heights[i]<heights[stack.peek()]){
               int height=heights[stack.pop()];
               int width=i-1-stack.peek();
               maxArea=Math.max(maxArea, height*width);
           }
           stack.push(i);
        }
        while (stack.peek()!=-1){
            int height=heights[stack.pop()];
            int width=heights.length-1-stack.peek();
            maxArea=Math.max(maxArea, height*width);
        }
        return maxArea;
    }

}
