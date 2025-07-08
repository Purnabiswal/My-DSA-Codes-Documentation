package src.Top150;

import java.util.Arrays;

//Q: merge two sorted array in nums1
class MergeSortedArrays_1 {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        //merge(nums1,3,nums2,3);
        merge2(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));//Not working outside function
    }
    //Correct and used in-place
    static public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--]=nums1[i--];
            }else{
                nums1[k--]=nums2[j--];
            }
        }
        while(i>=0){
            nums1[k--]=nums1[i--];
        }
        while(j>=0){
            nums1[k--]=nums2[j--];
        }
    }


    //Not working outside function
    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                arr[k++]=nums1[i++];
            }else{
                arr[k++]=nums2[j++];
            }
        }

        while(i<m){
            arr[k++]=nums1[i++];
        }
        while(j<n){
            arr[k++]=nums2[j++];
        }

        nums1= Arrays.copyOfRange(arr,0,arr.length);

        System.out.println(Arrays.toString(nums1));
    }


}