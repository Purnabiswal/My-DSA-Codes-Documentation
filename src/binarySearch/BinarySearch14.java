package src.binarySearch;

public class BinarySearch14 {
    public static void main(String[] args) {

        int[] arr={-18,-12,-4,0,2,3,4,15,16,18,22,45,89};
        int target= 22;
        System.out.println(search(arr,target));
    }



    //assumed that array is in ascending and sorted
    //return the index
    //return -1 if it does not exist
    static int search(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            //int mid = (start+end)/2  //Might be possible that (start+end) exceeds the range of "int" in java
            int mid = start+(end-start)/2;  //Formula for finding mid value
            if (target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
