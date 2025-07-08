package src.Sorting.Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/4sum/description/
public class FourSum {
    public static void main(String[] args) {
        int[] arr={2,2,2,2,2};
        System.out.println(threeSum(arr,8));
    }

    static List<List<Integer>> threeSum(int[] arr,int target){
        List<List<Integer>> arrayList=new ArrayList<>();

        Arrays.sort(arr);


        for (int i = 0; i < arr.length - 3; i++) {
//            if (i > 0 && arr[i] == arr[i - 1]) {
//                continue;
//            }
            //int left = i + 1;
            //int right = arr.length - 1;

            for (int j = i+1; j < arr.length - 2; j++) {

//                if (j > 0 && arr[j] == arr[j - 1]) {
//                    continue;
//                }
                int left = j + 1;
                int right = arr.length - 1;
                while (left < right) {
                    int sum = arr[left] + arr[right] + arr[i]+arr[j];

                    if (sum == target) {
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[left]);
                        list.add(arr[right]);
                        arrayList.add(list);

                        //arrayList.add(Arrays.asList(arr[i],arr[j], arr[left], arr[right]));
                        while (left < right && arr[left] == arr[left + 1]) left++;
                        while (left < right && arr[right] == arr[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }

        return arrayList;
    }
}
