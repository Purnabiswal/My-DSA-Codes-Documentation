package src.Recursion10.Recursion6_Permutations;

import java.util.ArrayList;

public class Permutations2 {
    public static void main(String[] args) {
        fun("","abc");
        System.out.println(fun2("","abc"));
        System.out.println(fun3("","abc"));
    }

    //Q1:
    static void fun(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for (int i = 0; i < p.length()+1; i++) { //using for loop for multiple fun calls
            String f=p.substring(0,i);
            String s=p.substring(i);
            fun(f+ch+s,up.substring(1));
        }
    }

    //Q2:
    //Return permutations in an ArrayList
    static ArrayList<String> fun2(String p, String up){
        ArrayList<String> list=new ArrayList<>();
        if (up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        for (int i = 0; i < p.length()+1; i++) { //using for loop for multiple fun calls
            String f=p.substring(0,i);
            String s=p.substring(i);
            list.addAll(fun2(f+ch+s,up.substring(1)));
        }
        return list;
    }

    //Q3:
    //Return permutations in an ArrayList
    static int fun3(String p, String up){
        int count=0;
        if (up.isEmpty()){
            return 1;
        }
        char ch=up.charAt(0);
        for (int i = 0; i < p.length()+1; i++) { //using for loop for multiple fun calls
            String f=p.substring(0,i);
            String s=p.substring(i);
            count += fun3(f+ch+s,up.substring(1));
        }
        return count;
    }
}
