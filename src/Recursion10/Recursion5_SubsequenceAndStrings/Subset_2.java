package src.Recursion10.Recursion5_SubsequenceAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Note:In recursion if you do not want to create a ArrayList or something inside the argument, then you need follow below things:
//1. Add returning elements to the current list
//2. And return the current list

public class Subset_2 {
    public static void main(String[] args) {
        //Subset_2 ob=new Subset_2();
        //ob.subSeq("","abc");
        //System.out.println(ob.subSeq2("","abc"));
        //ob.subSeqAscii("","abc");
        //System.out.println(ob.subSeqAsciiReturn("","abc"));


        int[] arr={1,2,2};
        //System.out.println(subSeqIterative(arr));
        int[] arr2={1,2,2,2,3};
        System.out.println(subSeqIterativeDup(arr2));
    }
    //Q9:
    //correct
    //Iterative approach to find subset with duplicates
    static List<List<Integer>> subSeqIterativeDup(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> mainList=new ArrayList<>();
        int i=0;
        int x=0;
        mainList.add(new ArrayList<>());
        while(i<arr.length){
            List<List<Integer>> temp=new ArrayList<>();
            int n=mainList.size();
//            int j=0;

            if (i>0 && arr[i]!=arr[i-1]){ //if no duplicates then start k from 0
                x=0;
            }
            for (int k = x; k <n; k++) {
                List<Integer> newSubList=new ArrayList<>(mainList.get(k));
                newSubList.add(arr[i]);
                temp.add(newSubList);
            }
//            for (List<Integer> subList : mainList){
//                if (i>0 && arr[i]==arr[i-1] && j < (n / 2)){
//                    j++;
//                }else {
//                    List<Integer> newSubList=new ArrayList<>(subList);
//                    newSubList.add(arr[i]);
//                    temp.add(newSubList);
//                }
//            }
            x= mainList.size();
            mainList.addAll(temp);
            i++;
        }
        return mainList;
    }
    //Q8:
    //Iterative approach to find subset
    static List<List<Integer>> subSeqIterative(int[] arr){
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> mainList=new ArrayList<>();
        int i=0;
        mainList.add(list);
        while(i<arr.length){
            List<List<Integer>> temp=new ArrayList<>();
            for (List<Integer> subList : mainList){
                List<Integer> newSubList=new ArrayList<>(subList); //Creating a new list because subList has the reference of mainList, thus if change subList it will also change the mainList values.
                newSubList.add(arr[i]);
                //mainList.add(newSubList); can't modify values in mainList while iterating with mainList
                temp.add(newSubList);
            }
            mainList.addAll(temp);
            i++;
        }
        return mainList;
    }

    //For arrays:subset, For Strings: Subsequence
    //Print the subsequence:
    void subSeq(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        subSeq(p+up.charAt(0),up.substring(1));
        subSeq(p,up.substring(1));
    }

    //Return the subsequence in a ArrayList:
    ArrayList<String> subSeq2(String p, String up){
        ArrayList<String> list=new ArrayList<>();
        if (p.isEmpty() && up.isEmpty()){ //To remove the last space in the subsequence
            return list;
        }
        if (up.isEmpty()){
            list.add(p);
            return list;
        }
        list.addAll(subSeq2(p+up.charAt(0),up.substring(1))); //Adding returning elements to the current list
        list.addAll(subSeq2(p,up.substring(1))); //Adding returning elements to the current list

        return list;  //And returning the current list
    }

    //Q7:
    void subSeqAscii(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        subSeqAscii(p+up.charAt(0), up.substring(1));
        subSeqAscii(p+(up.charAt(0)+0), up.substring(1)); //adding zero will covert it to Ascii value to a character
        subSeqAscii(p, up.substring(1));
    }

    //Q7: Return with arrayList
    ArrayList<String> subSeqAsciiReturn(String p, String up){
        ArrayList<String> list=new ArrayList<>();
        if (up.isEmpty()){
            list.add(p);
            return list;
        }

        list.addAll(subSeqAsciiReturn(p+up.charAt(0), up.substring(1)));
        list.addAll(subSeqAsciiReturn(p+(up.charAt(0)+0), up.substring(1))); //adding zero will covert it to Ascii value to a character
        list.addAll(subSeqAsciiReturn(p, up.substring(1)));

        return list;
    }


}






