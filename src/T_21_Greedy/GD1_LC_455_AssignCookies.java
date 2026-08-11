package src.T_21_Greedy;

import java.util.Arrays;

public class GD1_LC_455_AssignCookies {
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0, r=0;


        while(l<s.length && r<g.length){
            if(s[l]>=g[r]){
                r++;
            }
            l++;
        }

        return r;

    }
}
