package src.binarySearch;

//https://leetcode.com/problems/split-array-largest-sum/
//split array largest sum

//wrong answer
public class LC_410_part2 {
    public static void main(String[] args) {

        int[] arr={1,2,3,4,5};
        System.out.println(splitArray(arr,1));

    }
    static int splitArray(int[] arr, int m) {
        int s=0;
        int e=0;


        for (int elements : arr) {
            s = Math.max(s, elements);
            e += elements;
        }
        int pieces=1;

        //binary search
        while (s<e){
            int mid=s+(e-s)/2;

            //calculate how many pieces you can divide this in with this max sum
            //int sum=0;

            if(pieces>m){
                s=mid+1;
                pieces=findSum(arr,s,e);
            }else{
                e=mid;
                pieces=findSum(arr,s,e);
            }
        }

        return s;
    }
    static int findSum (int[] arr,int s,int e){
        int sum=0;
        int p=1;
        int mid=s+(e-s)/2;
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]<=mid){
                sum+=arr[i];
            }else {
                p++;
                sum=arr[i];
            }
        }
        return p;
    }

}
