package src.Arrays;

import java.util.Scanner;

public class LinearSearch8 {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        int[] arr={25,36,24,14,37,75,21};
        System.out.println("Enter number: ");
        int target=scan.nextInt();
        int ans=linearSearch(arr,target);
        System.out.println(ans);
        System.out.println(linearSearch2(arr,target));
    }

    //Search in the array: return the index if item found
    //otherwise if item not found return -1
    static int linearSearch(int[] arr,int target){
        if(arr.length==0){
            return -1;
        }

        for(int index=0;index<arr.length;index++){
            if (arr[index]==target){
                return index;
            }
        }

        //This line will execute if none of the return statements above have executed
        //hence the target not found
        return -1;
    }

    //search the target and return the element
    static int linearSearch2(int[] arr,int target){
        if(arr.length==0){
            return -1;
        }
        for(int element:arr){
            if (element==target){
                return element;
            }
        }
        //This line will execute if none of the return statements above have executed
        //hence the target not found
        return Integer.MAX_VALUE;
    }

    //search the target and return true or false
    static boolean linearSearch3(int[] arr,int target){
        if(arr.length==0){
            return false;
        }

        for(int element:arr){
            if (element==target){
                return true;
            }
        }

        //This line will execute if none of the return statements above have executed
        //hence the target not found
        return false;
    }

}
