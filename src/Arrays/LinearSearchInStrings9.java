package src.Arrays;

import java.util.Arrays;

public class LinearSearchInStrings9 {
    public static void main(String[] args) {
        //String[] arr={"Purna","Pixel","kfjk","red"};


        String name="Purna";
        char target='u';
        boolean ans=search(name,target);
        System.out.println(ans);

        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(search2(name,target));

    }

    static boolean search(String str,char target){
        if (str.isEmpty()){
            return false;
        }

        for (int i=0;i<str.length();i++){
            if (target==str.charAt(i)){
                return true;
            }
        }

        return false;
    }

    //Using for each loop
    static boolean search2(String str,char target){
        if (str.isEmpty()){
            return false;
        }

        for (char character: str.toCharArray()){
            if (target==character){
                return true;
            }
        }

        return false;
    }
}
