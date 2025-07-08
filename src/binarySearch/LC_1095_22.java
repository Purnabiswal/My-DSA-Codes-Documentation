package src.binarySearch;

//https://leetcode.com/problems/find-in-mountain-array/description/
public class LC_1095_22 {
    public static void main(String[] args) {

        int[] arr={1,5,2};
        int target=0;
        System.out.println(findInMountainArray(target,arr));
    }


    static public int findInMountainArray(int target, int[] arr) {

        int s=0;
        int e=arr.length-1;
        int ans;


        while (s<=e){
            int m=s+(e-s)/2;
            if (s==e){
                ans=check(arr,target,0,e,true);
                if (ans==-1){
                    ans=check(arr,target,s,arr.length-1,false);
                }
                return ans;
            }else if(arr[m]>arr[m+1]){
                e=m;
            }
            else if(arr[m]<arr[m+1]) {
                s=m+1;
            }
        }

        return -1;
    }

    static int check(int[] arr,int target,int s,int e,boolean isAsc){
        while (s<=e){
            int m=s+(e-s)/2;
            if (target==arr[m]){
                return m;
            }
            if (isAsc){
                if(target<arr[m]){
                    e=m-1;
                } else if(target>arr[m]){
                    s=m+1;
                }
            }else {
                if(target>arr[m]){
                    e=m-1;
                } else if(target<arr[m]){
                    s=m+1;
                }
            }

        }
        return -1;
    }

}
