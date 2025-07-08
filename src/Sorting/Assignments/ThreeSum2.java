package src.Sorting.Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/description/
public class ThreeSum2 {
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4,-2,-3,3,0,4}; //-1,0,1,2,-1,-4,-2,-3,3,0,4
        System.out.println(threeSum(arr));
    }

    static List<List<Integer>> threeSum(int[] arr){
        List<List<Integer>> list=new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int left=i+1;
            int right= arr.length-1;


            while (left<right){
                int sum=arr[left]+arr[right]+arr[i];

                if (sum==0){
                    list.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    while (left < right && arr[left] == arr[left + 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    right--;
                }
            }
        }

        return list;
    }
}
