package src.Recursion10.Recursion6_Permutations;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        String str="abcd";
        permutations("",str);
        System.out.println(permutationsRet("",str));
        System.out.println(numberOfPermutationsRet("",str));
    }

    //Q1:
    static public void permutations(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        //Why for loop? Ans: Because variable number of recursion calls are happening. See Recursion Tree to understand.
        for (int i = 0; i < p.length()+1; i++) {
            String f=p.substring(0,i);
            String s=p.substring(i);
            permutations(f+ch+s, up.substring(1));
        }
    }

    //Q2:
    //Return permutations in an ArrayList
    static public ArrayList<String> permutationsRet(String p, String up){
        ArrayList<String> list=new ArrayList<>();
        if (up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        //Why for loop? Ans: Because variable number of recursion calls are happening. See Recursion Tree to understand.
        for (int i = 0; i < p.length()+1; i++) {
            String f=p.substring(0,i);
            String s=p.substring(i);
            list.addAll(permutationsRet(f+ch+s, up.substring(1)));
        }
        return list;
    }

    //Q3:
    //Counting number of permutations
    static public int numberOfPermutationsRet(String p, String up){
        int c=0;
        if (up.isEmpty()){
            return 1;
        }
        char ch=up.charAt(0);
        //Why for loop? Ans: Because variable number of recursion calls are happening. See Recursion Tree to understand.
        for (int i = 0; i < p.length()+1; i++) {
            String f=p.substring(0,i);
            String s=p.substring(i);
            c += numberOfPermutationsRet(f+ch+s, up.substring(1));
        }
        return c;
    }
}
