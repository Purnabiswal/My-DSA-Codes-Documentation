package src.AdvanceSortingAlgorithms_17;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr={29,83,471,36,91,8};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //TC: O(digit * (n+base))
    //Base: base is the digit's place in number.
    // Ex: 473,
    // 1's place is 3.
    // 2's place is 7.
    // 3's place is 4.



    public static void radixSort(int[] arr){
        int max= Arrays.stream(arr).max().getAsInt();
//        int digit=(int) Math.log10(max)+1; //Or you can find digits

        //do count sort for every digit place
        for (int exp = 1; max/exp>0; exp*=10) {
            countSort(arr, exp);
        }


    }

    private static void countSort(int[] arr, int exp) {
        int n= arr.length;
        int[] output=new int[n];
        int[] count=new int[10];


        Arrays.fill(count, 0);
        //making a frequency array according to digit place
        for (int i = 0; i < n; i++) {
            count[(arr[i]/exp)%10]++;
        }
        System.out.println("Count array for 1's place"+Arrays.toString(count));

        for (int i = 1; i < 10; i++) {
            count[i]=count[i]+count[i-1]; //creating positions for every number in arr in the output array
        }
        System.out.println("Updated count array for 1's place"+Arrays.toString(count));

        for (int i = n-1; i >= 0; i--) {
            output[count[(arr[i]/exp)%10]-1]=arr[i]; //putting the original arr values in the output array at index present in the count array
            count[(arr[i]/exp)%10]--; //when the same digit again comes the put the new number behind the previous number
            //Example: Updated count array for 1's place[0, 2, 2, 3, 3, 3, 4, 4, 5, 6]
            //91 came first, so position of 91 is calculated as (91/1)%10 = 1 (means for 1's its first digit of number)
            //The answer 1 represents index in count array, (i.e. count[1] which equals to 2)
            //Then it is decreased by one i.e. 2-1 = 1, which is the index of the output array where 91 will be get in.
            //Then in the count array we decrease the 2 by 1, so that if a new element like 471 which also has "1" as the 1st digit like 91 is placed behind 91.

        }
        System.out.println("Output array for 1's place"+Arrays.toString(output));
        System.out.println();
        System.arraycopy(output, 0, arr, 0, n);

    }




}
