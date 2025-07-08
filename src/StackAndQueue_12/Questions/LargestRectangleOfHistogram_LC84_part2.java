package src.StackAndQueue_12.Questions;

public class LargestRectangleOfHistogram_LC84_part2 {
    public static void main(String[] args) {
        int[] arr={1};
        System.out.println(largestRectangleArea(arr));
    }


    //Boot force
    static public int largestRectangleArea(int[] heights) {
        int ans=0;
        int max=heights[0];

        for (int e:heights) {
            int count=0;
            for (int i:heights){
                if (i>=e){
                    count++;
                    ans=Math.max(ans, count);
                }else {
                    count=0;
                }
            }
            ans=ans*e;
            max=Math.max(max, ans);
            ans=0;
        }

        return max;
    }

}
