package src.Arrays;

import java.util.Scanner;

public class Max8 {
    public static void main(String[] args) {

        int[] arr={};

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter range:");
        int start=scan.nextInt(),end=scan.nextInt();
        System.out.println("Max value: "+max(arr));
        System.out.println("Max value in range "+start+" to "+end+" is "+maxRange(arr,start,end));

    }


    static int max(int[] arr){
        if(arr.length==0){
            return  -1;
        }
        int max=arr[0]; //int min=0; is wrong.
        for (int i=0;i<arr.length;i++){
            if (max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    static int maxRange(int[] arr,int start,int end){
        if (end<start){
            return -1;
        }
        if(arr==null){
            return -1;
        }
        int max=arr[0]; //int min=0; is wrong.
        for (int i=start;i<=end;i++){
            if (max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }

}
