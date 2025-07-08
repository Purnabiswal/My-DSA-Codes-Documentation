package src.Recursion10.Recursion3_ArrayQuestions;

import java.util.ArrayList;

//Array list is also mutable like Arrays
public class LinearSearch_2 {
    public static void main(String[] args) {
        int[] arr={3,2,5,1,8,6,1};
        int target=1;
        System.out.println("Does Exists: "+linearSearch2(arr,target));
        System.out.println("Index: "+linearSearch1(arr,target));
        System.out.println("All Index: "+findAllIndices(arr,target));
        System.out.println("All Index: "+findAllIndices2(arr,target));

    }

    //Q5:
    //Search for index without taking Arraylist in argument:
    //Not an optimized method, instead use Q4 solution
    //Marked for revision
    static ArrayList<Integer> findAllIndices2(int[] arr, int target){
        return searchAllIndex2(arr,target, 0);
    }
    static ArrayList<Integer> searchAllIndex2(int[] arr, int target, int index){
        ArrayList<Integer> list=new ArrayList<>();
        //base case
        if (index==arr.length){
            return list;
        }
        //This will contain answer for that function call only
        if (arr[index]==target){
            list.add(index);
        }
        //Solution: Add the list values while returning to the current list and return the current list
        list.addAll(searchAllIndex2(arr, target, index + 1));
        return list;
    }



    //Q4:
    //Search for index
    static ArrayList<Integer> findAllIndices(int[] arr, int target){
        ArrayList<Integer> list=new ArrayList<>();
        //return searchIndex(arr,target, 0, list);
        searchAllIndex(arr,target, 0, list);
        return list;
    }
    static ArrayList<Integer> searchAllIndex(int[] arr, int target, int index, ArrayList<Integer> list){
        //base case
        if (index==arr.length){
            return list;   //Base case value will travel across the previous function calls
        }
        if (arr[index]==target){
            list.add(index); //As array list is mutable, value that are added in every function call is
                             //adding to same array list, and it does not create any other objects of the array list for every calls
        }
        return searchAllIndex(arr,target,index+1,list);
    }


    //Q2:
    //Search for index
    static int linearSearch1(int[] arr, int target){
        return searchIndex(arr,target, 0);
    }
    static int searchIndex(int[] arr, int target, int index){
        //base case
        if (index==arr.length){
            return -1;
        }
        if (arr[index]==target){
            return index;
        }

        return searchIndex(arr,target,index+1);
    }


    //Q1:
    //Return true if present in the array
    static boolean linearSearch2(int[] arr, int target){
        return search(arr,target, 0);
    }
    static boolean search(int[] arr, int target, int index){
        //base case
        if (index==arr.length){
            return false;
        }
        return arr[index]==target || search(arr,target,index+1);
    }

}
