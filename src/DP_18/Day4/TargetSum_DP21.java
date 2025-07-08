package src.DP_18.Day4;

//Link:
//https://leetcode.com/problems/target-sum/
//https://www.naukri.com/code360/problems/target-sum_4127362?


import java.util.HashMap;
import java.util.Map;

//DP_21
public class TargetSum_DP21 {
    public static void main(String[] args) {

    }


    //Way-1:
    //Recursion
    public int findTargetSumWays(int[] num, int tar) {
        int n = num.length;
        return f(n-1, tar, num);
    }
    public int f(int n, int tar, int[] arr){
        if(n==0){
            int ans=0;
            if(arr[0] == tar) ans++;
            if(arr[0] == -tar) ans++;
            return ans;
        }

        int add = f(n-1, tar-arr[n], arr);
        int sub = f(n-1, tar+arr[n], arr);

        return add+sub;
    }


    //Memoization
    //For memoization use dp of type Map instead array as target may be -ve here and array won't allow -ve index.
    //DP: Map<Pair,Integer> dp = new HashMap<>();
//    class Pair{
//        int ind;
//        int tar;
//    }

    //Or, use this: DP: Map<String, Integer> dp = new HashMap<>();
    //where String consists with ind and tar like this: String key = ind+","+tar;


    //Similarly, you can do tabulation also. END.


    //Way-2
    //Using PartitionsWithGivenDifference_6
    public int findTargetSumWays2(int[] num, int tar) {
        int n = num.length;
        return countPartitions(n, tar, num);
    }

    //Space optimized version with slight modification(i.e. single array used)
    public static int countPartitions(int n, int d, int[] arr) {
        int toSum=0;
        for (int i = 0; i < n; i++) {
            toSum+=arr[i];
        }
        int div = toSum-d;
        if (div%2!=0 || div<0) return 0;
        int k = div/2; //k: Target
        int[] prev = new int[k+1];

        if (arr[0]==0){
            prev[0]=2;
        }else {
            prev[0]=1;
            if (arr[0]<=k){
                prev[arr[0]]=1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 0; j--) {
                int nonPick = prev[j];
                int pick = 0;
                if (j>=arr[i]){
                    pick = prev[j-arr[i]];
                }
                prev[j] = pick+nonPick;
            }
        }
        return prev[k];
    }

}
