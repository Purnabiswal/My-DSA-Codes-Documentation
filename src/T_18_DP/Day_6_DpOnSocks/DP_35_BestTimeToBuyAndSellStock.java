package src.T_18_DP.Day_6_DpOnSocks;

//LC_121
//https://www.naukri.com/code360/problems/best-time-to-buy-and-sell-stock_893405
public class DP_35_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] arr) {
        int profit=0;
        int min=arr[0];
        int prev;
        int cost;
        for(int i=1;i<arr.length;i++){
            prev=arr[i-1];
            if(prev<min){
                min=prev;
            }
            cost=arr[i]-min;
            if(cost>profit){
                profit=cost;
            }
        }

        return profit;
    }

    public int maxProfit2(int[] arr) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            min=Math.min(min, arr[i]);
            max=Math.max(max, arr[i]-min);
        }
        return max;
    }
}
