package src.T_18_DP.Day_7_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//LC_1048
public class DP_45_LongestStringChain {
    public static void main(String[] args) {

        String[] a={"a","b","ba","bca","bda","bdca"};
//        String[] a={"xbc","pcxbcf","xb","cxbc","pcxbc"};
//        String[] a={"abcd","dbqca"};
        System.out.println(longestStrChain(a));
        System.out.println(isPredecessor("b", "a"));
//        System.out.println(isPredecessor1("ba", "bca"));


    }


    //TC: O(n*n*l) + O(nlogn) , where l: max length string in string array
    //SC: O(n)
    static public int longestStrChain(String[] a) {
        int n=a.length;
        int[] dp=new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(a, Comparator.comparingInt(String::length));

        int max=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                boolean u=isPredecessor(a[j], a[i]);
                boolean v=isPredecessor1(a[j], a[i]);
                if (u!=v){
                    System.out.println( u +" "+ v);
                    System.out.println(a[i]+" "+ a[j]);
                }
                if (u && dp[i]<(dp[j]+1)){
                    dp[i]=dp[j]+1;
                }
            }
            max=(dp[max] > dp[i])?max:i;
        }




        return dp[max];
    }

    static boolean isPredecessor(String a, String b){
        int n=b.length();
        for (int i = 0; i < n; i++) {
            String newString=b.substring(0,i)+b.substring(i+1, n);
            if (a.equals(newString)){
                return true;
            }
        }
        return false;
    }


    static boolean isPredecessor1(String a, String b){
        int n=a.length();
        int m=b.length();
        int misMatch=0;
        int i=0;
        int j=0;
        if (m!=n+1) return false;
        while (i < n && j<m) {
            if (a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }else {
                j++;
                misMatch++;
                if (misMatch>1) return false;
            }
        }
        return true;
    }


}


//Leetcode discussion forum
class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        List<Data>[] list = new ArrayList[17];
        for(String w : words){
            if(list[w.length()]==null)list[w.length()] = new ArrayList<>();
            list[w.length()].add(new Data(w));
        }
        int mx = 1;
        for(int i = 1;i<=16;i++){
            if(list[i]==null)continue;
            for(Data d : list[i]){
                if(list[i-1]==null)d.count = 1;
                else {
                    for(Data old : list[i-1]){
                        if(check(old.word, d.word)){
                            d.count = Math.max(d.count, old.count+1);
                        }
                        mx = Math.max(mx, d.count);
                    }
                }
            }
        }
        return mx;
    }

    private boolean check(String word1, String word2){
        int k1 = 0, k2 = 0;
        while(k1<word1.length() && k2<word2.length()){
            if(word1.charAt(k1)!=word2.charAt(k2)){
                k2++;
            } else {
                k1++;
                k2++;
            }
            if(k2-k1>1)return false;
        }
        return k2-k1<=1;
    }

    static class Data {
        Integer count;
        String word;
        public Data(String word){
            this.word = word;
            count =1;
        }
    }
}