package src.Sorting;

//Hard
//https://leetcode.com/problems/first-missing-positive/
//amazon
//correct
public class LC_41_38 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(firstMissingPositive(nums));
    }

    static int firstMissingPositive(int[] nums) {
        int i=0;

        //sort only [1,n] and ignore elements that are -ve and >nums.length
        while(i<nums.length){
            int correct=nums[i]-1; //correct index= value-1;
            if(nums[i]>0 && nums[i]<nums.length && nums[i]!=nums[correct]){ //ignore >nums.length & -ve
                int t=nums[i];
                nums[i]=nums[correct];
                nums[correct]=t;
            }else {
                i++;
            }
        }
        //case 1
        for (int j = 0; j < nums.length; j++) {
            if(j!=nums[j]-1){
                return j+1;
            }
        }
        //case 2, if there is no missing, then return last index value + 1
        return nums.length+1;
    }
}
