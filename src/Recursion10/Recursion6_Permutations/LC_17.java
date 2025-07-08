package src.Recursion10.Recursion6_Permutations;

import java.util.ArrayList;
import java.util.List;

public class LC_17 {
    public static void main(String[] args) {
        List<String> list;
        list=letterCombinations("");
        System.out.println(list);
    }

    static String toMap(char n){
        return switch (n) {
            case '2' -> "abc";
            case '3' -> "def";
            case '4' -> "ghi";
            case '5' -> "jkl";
            case '6' -> "mno";
            case '7' -> "pqrs";
            case '8' -> "tuv";
            case '9' -> "wxyz";
            default -> "";
        };
    }

//    static public List<String> letterCombinations(String digits, String p, String up, List<String> list) {
//        for (int i = 0; i < digits.length(); i++) {
//            up=toMap(digits.charAt(i));
//            for (int j = 0; j < up.length(); j++) {
//
//
//            }
//        }
//    }

    static public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
//        if(digits.isEmpty()){
//            return list;
//        }
        //return letterCombinationsHelper(digits, "", toMap(digits.charAt(0)), list, 0);
        //return letterCombinationsHelper2(digits, "", toMap(digits.charAt(0)), list, 0);
        return letterCombinationsHelper3("", digits, list);
    }

    //Way-1:
    static public List<String> letterCombinationsHelper(String digits, String p, String up, List<String> list, int k) {
        if (k>=digits.length()){
            list.add(p);
            return list;
        }
        up=toMap(digits.charAt(k));
        for (int i = 0; i < up.length(); i++) {
            letterCombinationsHelper(digits, p+up.charAt(i), up, list, k+1);
        }
        return list;
    }

    //Way-2:
    static public List<String> letterCombinationsHelper2(String digits, String p, String up, List<String> list, int k) {
        if (up.isEmpty()){
            if (p.length()==digits.length()){
                list.add(p);
            }
            return list;
        }
        int y=k+1;
        String x;
        try {
            x=toMap(digits.charAt(y));
        } catch (Exception e) {
            x="";
        }
        letterCombinationsHelper2(digits, p+up.charAt(0), x, list, y);
        letterCombinationsHelper2(digits, p, up.substring(1), list, k);
        return list;
    }

    //Way-3:
    //Efficient: TC: 4^N
    static List<String> letterCombinationsHelper3(String p, String up, List<String> list){
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        int digit=up.charAt(0)-'0'; //This will convert '2' to 2
        int i = (digit-2)*3;
        int end=i+3;
        if (digit>7){
            i+=1;
        }
        if (digit==7 || digit==9){
            end+=1;
        }
        for (; i < end; i++) {
            char ch=(char) (i+'a');
            letterCombinationsHelper3(p+ch, up.substring(1), list);
        }
        return list;
    }
}
