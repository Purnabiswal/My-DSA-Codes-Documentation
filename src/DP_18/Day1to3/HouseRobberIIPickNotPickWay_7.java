package src.DP_18.Day1to3;

//Pick it or not pick it approach (like subset/subsequence problems)
public class HouseRobberIIPickNotPickWay_7 {
    public static void main(String[] args) {

        int[] nums={1,2,3};
        System.out.println(rob(nums));
    }


    //Tabulation
    //TC:O(N)
    //SC:O(1)
    //Space Efficient
    //213. House Robber II solution. Medium
    static public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick=Integer.MIN_VALUE;
            if (i!=n-1){
                pick=nums[i]+prev2;
            }

            int notPick=prev;
            int curi = Math.max(pick, notPick);
            prev2=prev;
            prev=curi;
        }
        int ans=prev;

        prev2 = 0;
        prev = Math.max(0, nums[1]);

        for (int i = 2; i < n; i++) {
            int pick=nums[i]+prev2;
            int notPick=prev;
            int curi = Math.max(pick, notPick);
            prev2=prev;
            prev=curi;
        }

        return Math.max(ans, prev);
    }


    //ChatGPT version
    public static int rob3(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Rob houses from index 0 to n - 2
        int money1 = robLinear(nums, 0, n - 2);

        // Rob houses from index 1 to n - 1
        int money2 = robLinear(nums, 1, n - 1);

        return Math.max(money1, money2);
    }

    private static int robLinear(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev = nums[start];

        for (int i = start + 1; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev;
            int cur = Math.max(pick, notPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }





}
