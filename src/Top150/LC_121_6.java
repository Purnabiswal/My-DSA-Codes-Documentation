package src.Top150;

public class LC_121_6 {
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    static public int maxProfit2(int[] arr) {
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        boolean found=false;
        int idx=n-1;
        int i;
        int profit=0;
        while(idx>=0){
            min=arr[idx];
            for(i=idx;i>=0;i--){
                if(arr[i]<min){
                    min=arr[i];
                    idx=i;
                }
            }
            for(int j=n-1;j>=idx;j--){
                if(arr[j]>max && arr[j]>=min){
                    max=arr[j];
                    found=true;
                }
            }
            profit=Math.max(max-min,profit);
            idx--;
        }

        return profit;
    }
    static public int maxProfit(int[] arr) {
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        boolean found=false;
        int idx=n-1;
        int i;
        int profit=0;
        while(idx>=0){
            min=arr[idx];
            for(i=idx;i>=0;i--){
                if(arr[i]<min){
                    min=arr[i];
                    idx=i;
                }
            }

            for(int j=n-1;j>=idx;j--){
                if(arr[j]>max && arr[j]>=min){
                    max=arr[j];
                    found=true;
                }
            }
            profit=Math.max(max-min,profit);
            idx--;
        }

        return profit;
    }
}
