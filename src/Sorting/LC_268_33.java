package src.Sorting;

//https://leetcode.com/problems/missing-number/description/
//Amazon question
//diff from kunal's video
public class LC_268_33 {
    public static void main(String[] args) {
        int[] arr={0,1,2}; //array should be continuous

        System.out.println(cycleSort(arr));
    }
    static int cycleSort(int[] nums){
        int i=0;
        int ans=0;
        while(i<nums.length){
            int correct=nums[i]-1; //correct index
            if(nums[i]==0){
                i++;
                ans=i;
            }
            else if(nums[i]!=nums[correct] ){ //checking the element is at its correct position or not
                int t=nums[i];
                nums[i]=nums[correct];
                nums[correct]=t;
            }else {
                i++;
            }
        }

        return ans;
    }
}
