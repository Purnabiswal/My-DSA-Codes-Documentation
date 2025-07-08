package src.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList5 {
    public static void main(String[] args) {

        int[] arr=new int[2]; //In array input size is mandatory

        //Syntax for ArrayList
        ArrayList<Integer> arrayList=new ArrayList<>(10);
        arrayList.add(55);
        System.out.println(arrayList.get(0));

//        arrayList.add(25);
//        arrayList.add(53);
//        arrayList.add(255);
//        arrayList.add(64);
//        arrayList.add(67);


        //System.out.println(arrayList.contains(25));

//        System.out.println(arrayList);
//        arrayList.set(0,99);
//        arrayList.remove(3);
//        System.out.println(arrayList);
//


        //Taking input
        Scanner scan=new Scanner(System.in);

        for (int i=0;i<6;i++){
            arrayList.add(scan.nextInt());
        }

        //Printing
        System.out.println(arrayList);

        //Printing by for loop
        for (int i=0;i<6;i++){
            System.out.print(arrayList.get(i)+" ");
        }
    }
}
