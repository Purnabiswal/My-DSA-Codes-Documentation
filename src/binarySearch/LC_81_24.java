package src.binarySearch;

//Rotated array with duplicate elements
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class LC_81_24 {
    public static void main(String[] args) {
        int[] arr={1,0,1,1,1};
        int target=0;
        System.out.println(search(arr,target));
    }




    static boolean search(int[] arr,int target){
        int s=0;
        int e=arr.length-1;
        while(s!=e && arr[s]==arr[e]){
            e=e-1;
        }
        int k;
        boolean ans=false;
        while (s<=e){
            int m=s+(e-s)/2;
            if (s==e ||arr[m]>arr[m+1]){
                k=m;
                ans=search2(arr,target,0,k);
                if(!ans){
                    ans=search2(arr,target,k+1,arr.length-1);
                }
                break;
            }else if (arr[m]>=arr[s]){
                s=m+1;
            }else {  //arr[m]<arr[0]
                e=m-1;
            }
        }


        return ans;
    }


    static boolean search2(int[] arr,int target,int s,int e){

        while (s<=e){
            int m=s+(e-s)/2;

            if(target<arr[m]){
                e=m-1;
            }else if(target>arr[m]){
                s=m+1;
            }else {
                return true;
            }
        }

        return false;
    }
}
