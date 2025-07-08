package src.Strivers.Recursion;

import java.util.*;

//LS_90
class Subset_II_LC90 {
    public static void main(String[] args) {
        int[] arr={4,4,4,1,4};
        System.out.println(subset(new ArrayList<>(), new ArrayList<>(),arr));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return subset(new ArrayList<>(), new ArrayList<>(), nums);
    }
    static List<List<Integer>> subset(List<List<Integer>> mainList, ArrayList<Integer> list, int[] arr){

        if(arr.length==0){
            Collections.sort(list);
            if (!mainList.contains(list)){//For not to add duplicates
                mainList.add(new ArrayList<>(list)); //copy and pass list values always
            }
            System.out.println(mainList);
            return mainList;
        }

        ArrayList<Integer> list2=new ArrayList<>(list);//copy's list's elements to list2
        list2.addLast(arr[0]);
        subset(mainList, list2, Arrays.copyOfRange(arr,1,arr.length));
        subset(mainList, list, Arrays.copyOfRange(arr,1,arr.length));
        return mainList;
    }
}