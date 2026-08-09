package src.Strivers;

import java.util.*;

public class Hello {
    public static void main(String[] args) {
        //list<int
        List<Integer> list=new ArrayList<>();


        list.add(2);
        list.add(1);
        list.add(2);
        list.add(5);

//        findDucplicates(list);

        int[] arr={2,5,6, 7,9,19};

        System.out.println(binarySearch(arr, 6));

    }

    static void findDucplicates(List<Integer> list){
        Set<Integer> set = new HashSet<>();

        for(Integer e:list) {
            if (set.contains(e)) {
                System.out.println(e);
            }

            set.add(e);

        }

    }



    static int binarySearch(int[] arr, int t){

        int s=0;
        int e=arr.length-1;

        int m;
        while (s<=e){
            m=s+(e-s)/2;

            if(t<arr[m]){
                e=m-1;
            } else if (t > arr[m]) {
                s=m+1;
            }else {
                return m;
            }
        }
        return -1;


    }

}
