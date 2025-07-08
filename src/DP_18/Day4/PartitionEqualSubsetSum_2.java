package src.DP_18.Day4;

//416. Partition Equal Subset Sum
public class PartitionEqualSubsetSum_2 {
    public static void main(String[] args) {
        int[] arr = {1,5,12,5};
        System.out.println(canPartition(arr));
    }


    static public boolean canPartition(int[] nums) {
        int totalSum=0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            totalSum+=nums[i];
        }
        int target = totalSum/2;
        if (totalSum%2!=0) return false;
        return subsetSumToK(n, target, nums);
    }


    //Tabulation version
    public static boolean subsetSumToK(int n, int k, int[] arr){
        boolean[] dp = new boolean[k+1];

        //base cases
        dp[0]=true;
        if (arr[0]<=k){
            dp[arr[0]]=true;
        }

        for (int i = 1; i < n; i++) {
            boolean[] cur = new boolean[k+1];
            cur[0]=true;
            for (int j = 1; j <= k; j++) {
                boolean nonTake = dp[j];
                boolean take = false;
                if (j>=arr[i]){
                    take = dp[j-arr[i]];
                }
                cur[j] = take || nonTake;
            }
            dp = cur;
        }

        return dp[k];
    }


    //Memoization version
    public static boolean subsetSumToK2(int n, int k, int[] arr){
        Boolean[][] dp = new Boolean[n][k+1];
        return f3(n-1,  k, arr, dp);
    }
    public static boolean f3(int n, int k, int[] arr, Boolean[][] dp){
        if (k==0){
            return true;
        }
        if (k<0 || n<0){
            return false;
        }
        if (dp[n][k]!=null){
            return dp[n][k];
        }

        return dp[n][k] = f3(n-1, k-arr[n], arr, dp) || f3(n-1, k, arr, dp);
    }






}
