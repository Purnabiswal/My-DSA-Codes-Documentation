package src.Top150;

import java.util.Arrays;

public class LC_80_4 {
    public static void main(String[] args) {
        int[] arr={0,0,0,0,1,1,1,2,3,3};
        removeDuplicates(arr);

    }
    static public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }

        int j = 2;
        for(int i=2; i<n; i++){
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }
}
