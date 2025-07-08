package src.Recursion10.Recursion1;

//Binary search using recursion
public class BinarySearch5 {
    public static void main(String[] args) {

        int[] arr={-1,0,3,-12,5,9,12};
        int target= 12;
        System.out.println(binarySearch(arr,target));
    }

    static int binarySearch(int[] arr,int target){
        int s=0;
        int e=arr.length-1;


        return search(arr,target,s,e);
    }

    static int search(int[] arr,int target,int s,int e){
        if (s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        //base condition
        if (arr[m]==target){
            return m;
        }

        //body
        int ans=(arr[m]<target)?(s=m+1):(e=m-1);


        return search(arr,target,s,e);
    }
}
