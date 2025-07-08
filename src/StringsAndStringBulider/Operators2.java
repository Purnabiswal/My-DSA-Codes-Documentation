package src.StringsAndStringBulider;

import java.util.ArrayList;

public class Operators2 {
    public static void main(String[] args) {
        System.out.println('a'+'b');
        System.out.println("a"+"b");
        System.out.println('a'+3);//char converts to its ascii value
        System.out.println((char)( 'a'+3));
        System.out.println("a"+1); //When an integer is concatenated(added) with a string it is converted to its wrapper class Integer that will call toString()
        //This is same as after a few steps: "a" + "1"

//        ArrayList<String> arrayList=new ArrayList<>(1);
//        arrayList.add("56");
//        arrayList.add("56f");
//        arrayList.add("abcd");
//        System.out.println(arrayList);

        System.out.println("Kunal"+new ArrayList<>()); //empty object, thus toString() will return "[]"
        System.out.println("Kunal"+56); //thus println always calls toString() method and converts everything to String and prints them.
//IMP   // System.out.println(56+new ArrayList<>()); //This will give error. "+" cannot be applied to integer and arraylist in java.
        //In java "+" operator can only be applied to primitives. It can also be applied to complex objects as well but the only condition is at least one of these object should be of type String.
        System.out.println(56+" "+new ArrayList<>()); //this will work


    }
}
