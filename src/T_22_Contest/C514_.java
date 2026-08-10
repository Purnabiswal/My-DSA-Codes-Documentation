package src.T_22_Contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/contest/weekly-contest-514/problems/minimum-total-price-after-applying-discounts/description/
public class C514_ {
    public static void main(String[] args) {
        int[] parent = {-1,0,0,0,2,2};
        int[] nums = {5,2,3,1,4,6};


        System.out.println(weightedSum(parent, nums));

    }

    static public long weightedSum(int[] parent, int[] nums) {
        int n=parent.length;
        int m=nums.length;

        int[] depth=new int[m];

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(parent[i]);
        }
        int h=set.size();

        depth[0]=1;
        for(int i=1;i<n && n>=1;i++){
            depth[i]=depth[parent[i]]+1;
        }

        System.out.println(h);
        System.out.println(Arrays.toString(depth));

        long sum=0;
        for(int i=0;i<m;i++){
            sum+=nums[i] * (h - depth[i] + 1);
        }

        return sum;
    }

    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double sum=0;
        int i=prices.length-1;
        int j=discounts.length-1;

        while(i>=0 && j>=0){
            sum+=prices[i]*(100.0-discounts[j])/100.0;
            i--;
            j--;
        }

        if(i<0) return sum;

        while(i>=0){
            sum+=prices[i];
            i--;
        }

        return sum;
    }
}
