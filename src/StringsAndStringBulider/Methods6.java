package src.StringsAndStringBulider;

import java.util.Arrays;

public class Methods6 {
    public static void main(String[] args) {
        String name="Purna Biswal"; //string is immutable(no change)

        System.out.println(Arrays.toString(name.toCharArray()));

        System.out.println(name.toLowerCase()); //string is immutable so no change in original String
        System.out.println(name);

        System.out.println(name.indexOf("a"));

        System.out.println("   Pixel   ");
        System.out.println("   Pixel   ".strip()); //removes extra space at the ends

        String fullName="Purna Chandra Biswal";
        System.out.println(Arrays.toString(fullName.split(" "))); //.split method splits the string into array of Strings
        System.out.println(Arrays.toString(fullName.split("a"))); //It also removes the ragex(here 'a') from the string
        System.out.println(Arrays.toString(fullName.split("")));

        System.out.println(fullName); //Still there is no change in fullName, this proves strings are immutable



    }
}
