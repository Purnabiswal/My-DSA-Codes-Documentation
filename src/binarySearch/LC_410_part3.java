package src.binarySearch;

//https://leetcode.com/problems/split-array-largest-sum/
//split array largest sum
//correct one
public class LC_410_part3 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(splitArray(arr,1));
    }
    static int splitArray(int[] arr, int m) {
        int s = 0;
        int e = 0;
        for (int i = 0; i < arr.length; i++) {
            s = Math.max(s, arr[i]);
            e += arr[i];
        }
        //binary search
        while (s < e) {
            int mid = s + (e - s) / 2;

            //calculate how many pieces you can divide this in with this max sum
            int sum=0;
            int pieces = 1;

            for(int num : arr){
                if (sum+num>mid){
                    //you can't add this in this sub array, make new one
                    //say you add this num in new sub array, then sum=num
                    sum=num;
                    pieces++;
                }else {
                    sum+=num;
                }
            }
            if (pieces > m) {
                s = mid + 1;
            }
            else {
                e = mid;
            }
        }
        return s;
    }
}