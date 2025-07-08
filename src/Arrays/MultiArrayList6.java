package src.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiArrayList6 {
    public static void main(String[] args) {


        Scanner scan=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arrayList=new ArrayList<>(2);

        //initialisation
//        for (int i=0;i<2;i++){
//            arrayList.add(new ArrayList<Integer>());
//        }

        //add elements
//        for (int i=0;i<3;i++){
//            for (int j=0;j<1;j++){
//                arrayList.get(j).add(scan.nextInt());
//            }
//        }
        int[] arr={2,3,4};
        ArrayList<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(22);
        list.add(23);
        arrayList.add(list);
        arrayList.add(list);

        //Printing
        System.out.println(arrayList);
    }
}
