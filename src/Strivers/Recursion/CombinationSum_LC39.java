package src.Strivers.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_LC39 {
    public static void main(String[] args) {
        int[] arr={2,3,6,7};
        int target=7;
        System.out.println(helper(0, new ArrayList<>(), new ArrayList<>(), arr, target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return helper(0, new ArrayList<>(), new ArrayList<>(), candidates, target);
    }
    static List<List<Integer>> helper(int sum, List<Integer> list, List<List<Integer>> mainList, int[] arr,int target){
        //System.out.println(mainList);
        if(sum>target){
            return mainList;
        }
        if(sum == target){
            mainList.add(new ArrayList<>(list));
            return mainList;
        }

        if(arr.length==0){
            
            return mainList;
        }

        //helper(sum+arr[0], list, mainList, arr, target);
        List<Integer> list2=new ArrayList<>(list);
        list2.add(arr[0]);
        helper(sum+arr[0], list2, mainList, arr, target);
        helper(sum, list, mainList, Arrays.copyOfRange(arr,1,arr.length), target);

        return mainList;
    }
}
