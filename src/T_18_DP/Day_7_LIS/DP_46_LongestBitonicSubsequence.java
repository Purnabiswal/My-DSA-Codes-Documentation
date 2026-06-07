package src.T_18_DP.Day_7_LIS;

import java.util.Arrays;

//LC_845 - similar one
//https://www.naukri.com/code360/problems/longest-bitonic-subsequence_1062688
public class DP_46_LongestBitonicSubsequence {
    public static void main(String[] args) {

        int[] a={1,2,1,3,4};
        int[] arr={20, 11, 8, 17, 38, 25, 41, 22, 32, 46, 34};
//        int[] arr={0,1,2,3,4,5,6,7,8,9};
//        int[] arr={0,2,0,2,1,2,3,4,4,1};
        System.out.println(longestBitonicSequence(arr, arr.length));
        System.out.println(longestMountain(arr));





//        int[] rev = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            rev[i] = arr[arr.length - 1 - i];
//        }
//        System.out.println(longestBitonicSequence(rev, arr.length));
    }


    public static int longestBitonicSequence(int[] a, int n) {
        n=a.length;
        int[] dpLIS=new int[n];
        int[] dpLDS=new int[n];
        Arrays.fill(dpLIS, 1);
        Arrays.fill(dpLDS, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j]<a[i]){
                    dpLIS[i]=Math.max(dpLIS[i], dpLIS[j]+1);
                }
                if (a[n-j-1]<a[n-i-1]){
                    dpLDS[n-i-1]=Math.max(dpLDS[n-i-1], dpLDS[n-j-1]+1);
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max=Math.max(dpLIS[i]+dpLDS[i]-1, max);
        }

        System.out.println(Arrays.toString(dpLIS));
        System.out.println(Arrays.toString(dpLDS));

        return max;
    }


    //leetcode one
    public static int longestMountain(int[] a) {
        int n=a.length;
        if(n<3) return 0;
        int[] dpLIS=new int[n];
        int[] dpLDS=new int[n];

        int[] rev = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            rev[i] = a[a.length - 1 - i];
        }


        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (a[j]<a[i] && a[j]<a[j+1] ){
                    dpLIS[i]=Math.max(dpLIS[i], dpLIS[j]+1);
                }else {
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (rev[j]<rev[i] && rev[j]<rev[j+1] ){
                    dpLDS[i]=Math.max(dpLDS[i], dpLDS[j]+1);
                }else {
                    break;
                }
            }
        }

        int max=0;
        for (int i = 0; i < n; i++) {
            if (dpLIS[i]==0 || dpLDS[n-i-1]==0){
                continue;
            }
            max=Math.max(dpLIS[i]+dpLDS[n-i-1]+1, max);
        }

        System.out.println(Arrays.toString(dpLIS));
        System.out.println(Arrays.toString(dpLDS));

        if (max<3) return 0;
        return max;
    }

}
