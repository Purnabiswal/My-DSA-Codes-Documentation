package src.Top150;

import java.util.Arrays;

public class LC_27_2 {
    public static void main(String[] args) {
        int[] nums = {1}; // Input array
        int val = 1; // Value to remove
        int[] expectedNums = {0}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElement(nums, val); // Calls your implementation

        assert k == expectedNums.length;
        Arrays.sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < nums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
    public static int removeElement(int[] nums, int val) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            while(i<nums.length && nums[i] != val){
                i++;
            }
            while(j>=0 && nums[j] == val){
                j--;
            }
            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
        }

        return i;
    }
}
