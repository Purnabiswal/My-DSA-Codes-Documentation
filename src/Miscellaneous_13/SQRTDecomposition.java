package src.Miscellaneous_13;

import java.util.Arrays;

//You can do any query, in this example we are doing sum query
public class SQRTDecomposition {
    public static void main(String[] args) {
        int[] arr={1,3,5,2,7,6,3,1,4,8};
        int n= arr.length;

        int sqrt=(int) Math.sqrt(n);
        int block_id=-1;
        int[] blocks=new int[sqrt+1];


        for (int i = 0; i < n; i++) {
            if ((i) % sqrt == 0) {//new block is starting
                block_id++;
            }
            blocks[block_id] += arr[i];
        }

        System.out.println(query(blocks,arr,2,7,sqrt));

        System.out.println(Arrays.toString(blocks));

        update(blocks, arr, 4, 8,sqrt);
        System.out.println(Arrays.toString(blocks));
    }

    //You can do any query, in this example we are doing sum query
    public static int query(int[] blocks, int[] arr, int l, int r, int sqrt){
        int ans=0;

        //left part
        while (l%sqrt != 0 && l<r && l!=0){
            ans+=arr[l++];
        }

        //middle part
        while (l+sqrt<=r){
            ans+=blocks[l/sqrt];
            l+=sqrt;
        }

        //right part
        while (l<=r){
            ans+=arr[l++];
        }
        return ans;
    }


    public static void update(int[] blocks, int[] arr, int i, int val, int sqrt){
        int block_id=i/sqrt;
        blocks[block_id] += val-arr[i];
        arr[i]=val;
    }


}
