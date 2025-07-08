package src.Recursion10.Recursion3_ArrayQuestions;

public class isSorted_1 {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,9,12};
        System.out.println(isSorted(arr));
    }

    static boolean isSorted(int[] arr){
        return helper2(arr,0);
        //return helper2(arr,0);
    }
    //way-1:
    static boolean helper(int[] arr, int a){
        if (a==arr.length-1){
            return true;
        }

        if (arr[a]>arr[a+1]){
            return false;
        }


        return helper(arr,a+1);
    }

    //way-2:
    //Best way:
    static boolean helper2(int[] arr, int index){
        //base case
        if (index==arr.length-1){
            return true;
        }
        return (arr[index]<arr[index+1]) && helper(arr,index+1);
    }
}
