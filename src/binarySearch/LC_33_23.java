package src.binarySearch;

//Rotated array with distinct elements
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class LC_33_23 {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search(arr,target));
    }

    //this will not work for duplicate values
    static int search(int[] arr,int target){
        int s=0;
        int e=arr.length-1;
        int pivot;
        int ans=-1;
        while (s<=e){
            int m=s+(e-s)/2;
            if (s==e ||arr[m]>arr[m+1]){
                pivot=m;
                if(target>=arr[0]){
                    ans=search2(arr,target,0,pivot);
                } else {
                    ans=search2(arr,target,pivot+1,arr.length-1);
                }
//                ans=search2(arr,target,0,pivot);
//                if(ans==-1){
//                    ans=search2(arr,target,pivot+1,arr.length-1);
//                }
                break;
            }
            else if (arr[m]>=arr[0]){
                s=m+1;
            }else {  //arr[m]<arr[0]
                e=m-1;
            }
        }

        return ans;
    }

    static int search2(int[] arr,int target,int s,int e){

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

}
