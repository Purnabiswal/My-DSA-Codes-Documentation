package src.T_18_DP.Day_7_LIS;

import java.util.Arrays;

//LC_673
//https://www.naukri.com/code360/problems/number-of-longest-increasing-subsequence_3751627
public class DP_47_NumberOfLongestIncreasingSubsequences {
    public static void main(String[] args) {

//        int[] a={1,3,5,4,7};
//        int[] a={3 ,7, 4, 6};
//        int[] a={5, 7, 2, 3};
//        int[] a={1,2,4,3,5,4,7,2};
//        int[] a={1,2,3,1,2,3,1,2,3};
        int[] a={1,5,4,3,2,6,7,10,8,9};
//        int[] a={2,2,2,2,2};
//        int[] a={50, 3, 90, 60, 80};
        System.out.println(findNumberOfLIS(a));
    }

    static public int findNumberOfLIS(int[] a) {
        int n=a.length;
        int[] dp=new int[n];
        int[] counter=new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(counter, 1);
        int max=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j]<a[i]){
                    if (dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        counter[i]=counter[j];
                    }else if (dp[j]+1==dp[i]){
                        counter[i]+=counter[j];
                    }
                }
            }
            max=Math.max(max, dp[i]);
        }

        int ans=0;
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(counter));
        System.out.println("Max "+max);
        for (int i = 0; i < n; i++) {
            if (dp[i]==max) {
                ans+=counter[i];
            }
        }

        return ans;
    }
}
