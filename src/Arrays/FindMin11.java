package src.Arrays;

public class FindMin11 {
    public static void main(String[] args) {
        int[] arr={18,12,-7,3,14,28};
        System.out.println(min(arr));
    }

    //return the minimum value in the array
    static int min(int[] arr){
        if (arr.length==0){
            return -1;
        }
        int min=arr[0]; //int min=0; is wrong.
        for (int element:arr){
            if(element<min){
                min=element;
            }
        }
        return min;
    }
}
