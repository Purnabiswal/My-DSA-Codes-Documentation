package src.binarySearch;

//https://leetcode.com/problems/split-array-largest-sum/
//split array largest sum

//wrong answer(this code partially correct, i.e. works only for k=2)
public class LC_410_26 {
    public static void main(String[] args) {
        int[] arr={1,4,4};
        int k=3;
        System.out.println(splitArray(arr,k));
    }
    static int splitArray(int[] arr,int k){
        int s=0;
        int e=arr.length-1;
        int t=0;
        int p=0;
        int q=0;
        int x1 =0;
        int y1 =0;
        int x2 =0;
        int y2 =0;
        for(int element : arr){
            t=t+element;
        }
        for (int i=0;i<=arr.length-1;i++){
            p=p+arr[i];
            q=t-p;
            if(p>t/k){
                y1 =p;
                if (y1 < x1 || i==0 || i==arr.length-2){
                    x1 = y1;
                }
            }else {
                y2 =q;
                if(y2<x2 || i==0 || i==arr.length-2){
                    x2=y2;
                }
            }
        }

        if (x1>=x2){
            return x2;
        }

        return x1;
    }
}
