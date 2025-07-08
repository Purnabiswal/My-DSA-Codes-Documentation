package src.binarySearch;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class LC_852_21 {
    public static void main(String[] args) {
        int[] arr={3,5,3,2,0};
        System.out.println(search(arr));
    }

    static int search(int[] arr){
        int s=0;
        int e=arr.length-1;
        int peak;
        while(true){
            int m=s+(e-s)/2;
            if(m==0 || m==arr.length-1){
                peak=e;
                break;
            }else if(arr[m]>arr[m-1] && arr[m]>arr[m+1] ){
                peak=m;
                break;
            }else if(arr[m]>arr[m-1] && arr[m]<arr[m+1]){
                s=m+1;
            }else {
                e=m-1;
            }
        }
        return peak;
    }
}
