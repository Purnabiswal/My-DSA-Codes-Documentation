package src.Recursion10.Recursion3_ArrayQuestions;

//LC_33
//Rotated binary search
public class BinarySearchInRotatedArray_3 {
    public static void main(String[] args) {
        int[] arr={1,3,5};
        int target=2;
        System.out.println(search2(arr,target));
    }
    //using loop
    static int search(int[] arr, int target){
        int s=0;
        int e=arr.length-1;
        int pivot;
        int ans=-1;
        while (s<=e){
            int m=s+(e-s)/2;
            if (arr[m]==target){
                return m;
            }else if (arr[s]<=arr[m]){
                if (target>=arr[s] && target<=arr[m] ){
                    e=m-1;
                }else {
                    s=m+1;
                }
            }else{
                if (target<arr[s] && target>=arr[m]){
                    s=m+1;
                }else {
                    e=m-1;
                }
            }
        }
        return ans;
    }

    //using recursion:
    static int search2(int[] arr, int target){
        return helper(arr, target,0,arr.length-1);
    }
    static int helper(int[] arr, int target, int s, int e ){

        int m=s+(e-s)/2;
        if (s>e){
            return -1;
        }
        if (arr[m]==target){
            return m;
        }
        if (arr[s]<=arr[m]){
            if (target>=arr[s] && target<=arr[m] ){
                return helper(arr,target,s,m-1);
            }else {
                return helper(arr, target, m+1, e);
            }
        }else{
            if (target<arr[s] && target>=arr[m]){
                return helper(arr, target, m+1, e);
            }else {
                return helper(arr,target,s,m-1);
            }
        }
    }
}
