package src.Strivers.ArrayPart4;

//TC: O(n*n)
//Not a optimized code
public class LargestSubarraySumZero_1 {
    public static void main(String[] args) {
        int[] arr={15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr));
    }
    static int maxLen(int[] arr) {
        int longest=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                if (sum==0){
                    longest=Integer.max(longest,j-i+1);
                }
            }
            sum=0;
        }
        return longest;
    }
}
