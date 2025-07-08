package src.binarySearch;

//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//Infinite array
public class GFG_20 {
    public static void main(String[] args) {
        int[] arr={3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target=10;
        System.out.println(search(arr,target));
    }

    static int search(int[] arr,int target){
        int s,e;
        int[] range= findRange(arr,target);
        s=range[0];
        e=range[1];

        while (s<=e){
            int m=s+(e-s)/2;
            if(target<arr[m]){
                e=m-1;
            }else if(target>arr[m]){
                s=m+1;
            }else {
                return m;
            }
        }

        return -1;
    }

    static int[] findRange(int[] arr,int target){
        //first find the range
        //first start with a box of size 2
        int s=0;
        int e=1;


        while(s<=e){
            if(target<arr[e] && target>arr[s]){
                return new int[]{s,e};
            }else {
                s=e+1;
                e=((s*2)+1);
            }
        }

        return new int[]{s,e};
    }
}
