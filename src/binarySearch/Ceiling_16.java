package src.binarySearch;

public class Ceiling_16 {
    public static void main(String[] args) {
        //Ceiling: smallest element in the array greater or equal to the target
        //Floor: biggest element in the array smaller or equal to the target

        int[] arr={2,3,5,9,14,16,18};
        int target=18;
        System.out.println(ceiling(arr,target));
    }

    //return the index of smallest element >=target
    static int ceiling(int[] arr, int target){
        int start=0;
        int end=arr.length;

        if (target>arr[arr.length-1]) return -1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }else {
                return mid;
            }
        }
                       //Do same as BS then,
        return start;  //return start if ceiling asked
                       //return end if floor asked
    }

}
