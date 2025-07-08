package src.Arrays;

import java.util.Arrays;

public class PassingInFunctions2 {
    public static void main(String[] args) {


        int[] arr={5,3,9,75,6};
        String x="Purna";
        System.out.println(Arrays.toString(arr)+","+x);

        change(arr,x);
        System.out.println(Arrays.toString(arr)+","+x);// Strings are immutable thus the string value is not changed at all. But arrays are mutable.
    }

    static void change(int[] arr,String a){
        arr[0]=99;
        a="Pixel";
    }
}
