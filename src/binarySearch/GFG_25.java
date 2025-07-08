package src.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class GFG_25 {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(findKRotation(arr));

    }

    static int findKRotation(List<Integer> arr){
        int s=0;
        int e=arr.size()-1;
        int p = 0;


        while(s<e){
            int m=s+(e-s)/2;
            if (arr.get(m) > arr.get(m + 1)){
                p=m;
                break;
            } else if (arr.get(m) > arr.get(s)) {
                p = m;
                s = m + 1;
            } else {
                e = m;
            }
        }
        if(s==e){
            return 0;
        }
        return p+1;
    }
}
