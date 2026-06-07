package src.T_18_DP.Day_7_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LC_368
//https://www.naukri.com/code360/problems/divisible-set_3754960
public class DP_44_LargestDivisibleSubset {
    public static void main(String[] args) {

    }


    static public List< Integer > largestDivisibleSubset(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        int[] dp=new int[n];
        int[] hash=new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i]=-1;
//            hash[i]=-1;
//        }
        Arrays.fill(dp, 1);
        Arrays.fill(hash, -1);
        int max=0;


        //O(n*n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i]%a[j]==0 && dp[i]<(dp[j]+1) ){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            max=(dp[max] > dp[i])?max:i;
        }
        List<Integer> list=new ArrayList<>();
        list.add(a[max]);
        //backtrack
        //O(n)
        while(max>0 && hash[max]!=-1){
            list.add(0, a[hash[max]]);
            max=hash[max];
        }
        return list;
    }






    //No as such changes done
    public List<Integer> largestDivisibleSubset2(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        int[] dp=new int[n];
        int[] hash=new int[n];

        int max=0;
        for (int i = 0; i < n; i++) {
            dp[i]=-1;
            hash[i]=i;
            for (int j = 0; j < i; j++) {
                if (a[i]%a[j]==0 && dp[i]<(dp[j]+1) ){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            max=(dp[max] > dp[i])?max:i;
        }
        List<Integer> list=new ArrayList<>();
        list.add(a[max]);
        while(hash[max]!=max){
            list.add(0, a[hash[max]]);
            max=hash[max];
        }
        return list;
    }

}
