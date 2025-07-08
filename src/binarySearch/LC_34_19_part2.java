package src.binarySearch;

import java.util.Arrays;

public class LC_34_19_part2 {
    public static void main(String[] args) {
        //Another way
        //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
        int[] arr={5,7,7,8,8,10};
        int target=8;
        System.out.println(Arrays.toString(search(arr,target)));
    }

    static int[] search(int[] arr,int target){

        int[] ans = {-1,-1};
        ans[0]=search2(arr,target,true);   //check for first occurrence of target first
        if (ans[0]!=-1) ans[1]=search2(arr,target,false);  //check for second occurrence of target

        return ans;
    }

    //This function just returns the last index value of target
    static int search2(int[] arr,int target,boolean startIndex){
        int start=0;
        int end=arr.length-1;
        int ans=-1;

        while(start<=end){
            int m=start+(end-start)/2;
            if (target<arr[m]){
                end=m-1;
            }else if(target>arr[m]){
                start=m+1;
            }else {
                if (startIndex){
                    end=m-1;
                }else {
                    start=m+1;
                }
                ans=m;
            }
        }
        return ans;
    }
}
