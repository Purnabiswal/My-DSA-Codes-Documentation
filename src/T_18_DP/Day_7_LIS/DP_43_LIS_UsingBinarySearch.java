package src.T_18_DP.Day_7_LIS;

//LC_300
//https://www.naukri.com/code360/problems/longest-increasing-subsequence_1062665
public class DP_43_LIS_UsingBinarySearch {
    public static void main(String[] args) {

//        int[] a={10,9,2,5,3,7,101,18};
        int[] a={10,9,2,5,3,7,101,18};
//        int[] a={1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(a));
    }

    //This only works for LIS len not print LIS
    //TC: O(nlogn)
    //SC: O(n)
    static public int lengthOfLIS(int[] a) {
        int n=a.length;
        int[] dp=new int[n];
        int len=1;
        dp[0]=a[0];
        for (int i = 1; i < n; i++) {
            if (dp[len-1]<a[i]){
                dp[len]=a[i];
                len++;
            }else {
                binarySearch(len, a[i], dp);
            }
        }
        return len;
    }

    static public void binarySearch(int e, int t, int[] dp){
        int s=0;
        while (s<=e){
            int m=s+(e-s)/2;
            if (t<dp[m]){
                e=m-1;
            }else if (t>dp[m]){
                s=s+1;
            }else {
                dp[m]=t;
                return;
            }
        }
        dp[s]=t;
    }
}
