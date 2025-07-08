package src.Arrays;

import java.util.Scanner;

public class SearchInRange10 {
    public static void main(String[] args) {
        int[] arr={18,12,-7,3,14,28};
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter element: ");
        int target=scan.nextInt();
        System.out.println("Enter range: ");
        int start=scan.nextInt();
        int end=scan.nextInt();
        int ans=linearSearch(arr,target,start,end);
        System.out.println("The index of the element: "+ans);
    }

    static int linearSearch(int[] arr,int target,int start,int end){
        if(arr.length==0){
            return -1;
        }

        for(int index=start;index<end;index++){
            if (arr[index]==target){
                return index;
            }
        }

        //This line will execute if none of the return statements above have executed
        //hence the target not found
        return -1;
    }
}
