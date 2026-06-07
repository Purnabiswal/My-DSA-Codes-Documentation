package src.Top150;

public class TP_7_LC_55_JumpGame {
    public static void main(String[] args) {

    }

    //Rec
    public boolean canJump(int[] nums) {
        return f(0, nums);
    }

    public boolean f(int i, int[] arr){
        if(i==arr.length-1) return true;

        int max_h=arr[i];
        for(int j=1;j<=max_h; j++){
            if(f(i+j, arr)) return true;
        }
        return false;
    }

    //Memo
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        return f2(0, nums, dp);
    }

    public boolean f2(int i, int[] arr, int[] dp){
        if(i==arr.length-1) return true;
        if (dp[i]!=0) return dp[i]==1;
        int max_h=arr[i];
        for(int j=1;j<=max_h && i+j< arr.length; j++){
            if(f2(i+j, arr, dp)) {
                dp[i]=1;
                return true;
            }
        }
        dp[i]=-1;
        return false;
    }



    //Optimal(Greedy):
    public boolean canJump3(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;

            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }

}
