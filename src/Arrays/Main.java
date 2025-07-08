package src.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

    //     //Array syntax: datatype[] variable_name = new datatype[size];
    //     int[] roll=new int[5];
    //     //Or directly
    //     int[] roll2={11,12,23,24};

    //     System.out.println(roll[4]);

    //     String[] arr=new String[4];
    //     System.out.println(arr[2]);


    //     //null can only be assigned to non-primitive datatypes


      

    //    //array of primitive

    //     Scanner in=new Scanner(System.in);
    //     System.out.print("Enter size of the array:");
    //     int[] input=new int[in.nextInt()];

    //     //Taking input for Array
    //     for (int i=0;i<input.length;i++) {
    //         input[i]=in.nextInt();
    //     }

    //     //By for loop
    //     for(int i=0;i<input.length;i++){
    //         System.out.println("Array values:"+input[i]);
    //     }

    //     //By for each loop
    //     for(int num:input){
    //         System.out.println("Array values by for each:"+num);
    //     }

    //     //By array class toString()
    //     System.out.println("By Array class toString(): "+Arrays.toString(input));



        //array of objects
        String[] str=new String[4];
        Scanner scan=new Scanner(System.in);

        for(int i=0;i<str.length;i++){
            str[i]=scan.next();
        }

        System.out.println(Arrays.toString(str));

        str[2]="gggggg";

        System.out.println(Arrays.toString(str));







    }
    
}
