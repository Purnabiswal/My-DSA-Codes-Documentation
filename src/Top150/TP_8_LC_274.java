package src.Top150;

import java.util.Arrays;

public class TP_8_LC_274 {
    public static void main(String[] args) {
        int[] a={1,3,1};
        System.out.println(hIndex(a));
    }

    //Not a optimal solution
    static public int hIndex(int[] citations) {
        int n=citations.length;
        Arrays.sort(citations);
        int i=n-1;
        int max=Integer.MIN_VALUE;
        while(i>=0){
            max= Math.max(max, Math.min(n-i, citations[i]));
            i--;
        }
        return max;
    }
}
