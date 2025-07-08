package src.Recursion10.Recursion6_Permutations;

import java.util.ArrayList;
import java.util.List;

public class temp {
    public static void main(String[] args) {
        List<String> list=letterCombinations("8");
        System.out.println(list.size()+" "+list);

    }

    static public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.isEmpty()){
            return list;
        }
        return letterCombinationsHelper3("", digits, list);
    }
    static List<String> letterCombinationsHelper3(String p, String up, List<String> list){
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        int digit=up.charAt(0)-'0'; //This will convert '2' to 2
        int i = (digit-2)*3;
        if (digit>7){
            i+=1;
        }
        int end=i+3;
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
