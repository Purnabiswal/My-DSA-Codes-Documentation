package src.T_22_Contest;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-514/problems/minimum-total-price-after-applying-discounts/description/
public class C514_ {
    public static void main(String[] args) {

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
