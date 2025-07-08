package src.Sorting;

//https://leetcode.com/problems/find-the-duplicate-number/description/
//diff from kunal's video
public class LC_287_35 {
    public static void main(String[] args) {
        int[] arr={1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }
    static int findDuplicate(int[] nums){
        int i=0;
        while (i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                int t=nums[i];
                nums[i]=nums[correct];
                nums[correct]=t;
            }else {
                i++;
            }
        }

        for(int j=0;j<nums.length;j++){
            if(j!=nums[j]-1){
                return nums[j];
            }
        }
        return -1;
    }
}
