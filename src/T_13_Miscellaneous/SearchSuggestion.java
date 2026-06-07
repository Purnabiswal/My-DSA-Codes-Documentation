package src.T_13_Miscellaneous;

import java.util.*;

public class SearchSuggestion {
    public static void main(String[] args) {
//        StringBuilder str = new StringBuilder();
//        str.append("jdih");
//        str.append("hrhr");
//        System.out.println(str);

        //rough
        String s = "ate";
        char[] arr=s.toCharArray();
        Arrays.sort(arr);
        String x= Arrays.toString(arr);
        System.out.println(x);


        Map<Integer, String> map = new HashMap<>();
        
        List<List<String>> mainList = new ArrayList<>();
        mainList.get(0).add(x);


    }


//    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//
//    }

}

interface Test{
    int aMethod(String s);
}