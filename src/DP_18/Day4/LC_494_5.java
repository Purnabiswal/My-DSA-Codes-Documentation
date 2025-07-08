package src.DP_18.Day4;

import java.util.HashMap;
import java.util.Map;

public class LC_494_5 {
    public static void main(String[] args) {
        int[] arr={1,1,1,1,1};
        System.out.println(findTargetSumWays(arr, 3));
        System.out.println(findTargetSumWays2(arr, 3));
    }

    //Recursion
    public static int findTargetSumWays(int[] num, int tar) {
        return f(num.length-1, tar, num);
    }
    public static int f(int n, int k, int[] arr){
        if(n<0){
            if (k==0) return 1;
            return 0;
        }

        int nonPick = f(n-1, k+arr[n], arr);
        int pick = f(n-1, k-arr[n], arr);

        return pick+nonPick;
    }


    //Memoization
    public static int findTargetSumWays2(int[] num, int tar) {
        Map<String, Integer> memo = new HashMap<>();
        return f2(num.length-1, tar, num, memo);
    }
    public static int f2(int n, int k, int[] arr, Map<String, Integer> memo){
        if(n<0){
            if (k==0) return 1;
            return 0;
        }
        String key = n+","+k;
        if (memo.containsKey(key)){
            return memo.get(key);
        }

        int nonPick = f2(n-1, k+arr[n], arr, memo);
        int pick = f2(n-1, k-arr[n], arr, memo);
        memo.put(key, pick+nonPick);
        return pick+nonPick;
    }

    //Tabulation
    public static int findTargetSumWays3(int[] num, int tar) {
        Map<String, Integer> memo = new HashMap<>();

        


        return f2(num.length-1, tar, num, memo);
    }


}
