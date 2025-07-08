package src.Strivers.Arrays;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr={0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    static public void moveZeroes(int[] arr) {
        int position=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                if (i>0 && arr[i-1] !=0){
                    position=i;
                }
                if (i==0){
                    position=i;
                }
                if((i+1)<arr.length && arr[i+1] != 0){
                    swap(arr,i+1,position);
                    position++;
                }
            }
        }
    }

    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}