package src.T_18_DP.Day_7_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.naukri.com/code360/problems/printing-longest-increasing-subsequence_8360670
public class DP_42_PrintingLongestIncreasingSubsequence {
    public static void main(String[] args) {

//        int[] a={1, 2, 3, 4, 5};
//        int[] a={5, 6, 3, 4, 7, 6};
        int[] a={40 ,30, 14 ,25 ,24 ,25 ,42, 37 ,46, 9, 30, 39};
        System.out.println(printingLongestIncreasingSubsequence4(a, a.length));

    }


    //Another way:
    //New way
    //Tabulation
    //TC: O(n*n)
    //SC: O(n)
    static public List< Integer > printingLongestIncreasingSubsequence4(int[] a, int n) {
        n=a.length;
        int[] dp=new int[n];
        Arrays.fill(dp, 1);
        int[] hash=new int[n];
        Arrays.fill(hash, -1);
        int max=1;
        for (int i = 0; i < n; i++) {
            hash[i]=i;
            for (int j = 0; j < i; j++) {
                if (a[j]<a[i] && dp[i]<(dp[j]+1)){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            max=(dp[max] > dp[i])?max:i;
        }


        List<Integer> list=new ArrayList<>();
        list.add(a[max]);
        //backtrack
        while(hash[max]!=max){
            list.add(0, a[hash[max]]);
            max=hash[max];
        }


        return list;
    }







    //My way:

    //Recursion
    public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int n) {
        return f(0, -1, arr, n);
    }
    public static List< Integer > f(int i, int prev, int []arr, int n) {
        if(i==n) return new ArrayList<Integer>();

        List<Integer> nonPick=f(i+1, prev, arr, n);
        List<Integer> pick=new ArrayList<>();

        if(prev==-1 || arr[i]>arr[prev]){
            pick.add(arr[i]);
            pick.addAll(f(i+1, i, arr, n));
        }

        return (nonPick.size()>pick.size())?nonPick:pick;
    }


    //Recursion with shifting
    public static List< Integer > printingLongestIncreasingSubsequence2(int []arr, int n) {
        return f2(1, 0, arr, n);
    }
    public static List< Integer > f2(int i, int prev, int []arr, int n) {
        if(i==n+1) return new ArrayList<>();

        List<Integer> nonPick=f2(i+1, prev, arr, n);
        List<Integer> pick=new ArrayList<>();

        if(prev==0 || arr[i-1]>arr[prev-1]){
            pick.add(arr[i-1]);
            pick.addAll(f2(i+1, i, arr, n));
        }

        return (nonPick.size()>pick.size())?nonPick:pick;
    }





    //Memo
    //Incomplete
    public static List< Integer > printingLongestIncreasingSubsequence3(int []arr, int n) {
        int[][] dp=new int[n+1][n];
        for (int[] e:dp){
            Arrays.fill(e, -1);
        }
        return f3(1, 0, arr, n, dp);
    }
    public static List< Integer > f3(int i, int prev, int []arr, int n, int[][] dp) {
        if(i==n+1) return new ArrayList<>();



        List<Integer> nonPick=f3(i+1, prev, arr, n, dp);
        List<Integer> pick=new ArrayList<>();

        if(prev==0 || arr[i-1]>arr[prev-1]){
            pick.add(arr[i-1]);
            pick.addAll(f3(i+1, i, arr, n, dp));
        }

        return (nonPick.size()>pick.size())?nonPick:pick;
    }


    //you can do further similarly









}
