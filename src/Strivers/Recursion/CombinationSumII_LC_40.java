package src.Strivers.Recursion;

import java.util.*;

public class CombinationSumII_LC_40 {
    public static void main(String[] args) {
        int[] arr={10,1,2,7,6,1,5};
        int target=8;
        System.out.println(combinationSum2(arr,target));
    }
    static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        ans= helper(0,new ArrayList<>(), candidates, ans, target);
        return new ArrayList<>(ans);
    }
    static Set<List<Integer>> helper(int sum, ArrayList<Integer> list, int[] arr, Set<List<Integer>> mainList, int target){
        if(sum>target){
            return mainList;
        }
        if(arr.length==0){
            if(sum==target){
                if(!mainList.contains(list)){

                    mainList.add(new ArrayList<>(list));
                }
            }
            return mainList;
        }

        list.add(arr[0]);
        helper(sum+arr[0], list, Arrays.copyOfRange(arr, 1,arr.length), mainList, target);
        list.remove(list.size()-1);
        helper(sum, list, Arrays.copyOfRange(arr, 1,arr.length), mainList, target);

        return mainList;
    }
}
