package src.Arrays;

public class LC_1672_13 {
    public static void main(String[] args) {
        int[][] accounts = {{2,8,7},{7,1,3},{1,9,5}};
        System.out.println(wealth(accounts));
        System.out.println(wealth2(accounts));
    }

    static int wealth(int[][] arr){
        int max=0;
        for(int row=0;row<arr.length;row++){
            int sum=0;
            for(int col=0;col<arr[row].length;col++){
                sum=sum+arr[row][col];
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }

    static int wealth2(int[][] arr){
        int max=0;
        for(int[] element1: arr){
            int sum=0;
            for(int element:element1){
                sum+=element;
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
}
