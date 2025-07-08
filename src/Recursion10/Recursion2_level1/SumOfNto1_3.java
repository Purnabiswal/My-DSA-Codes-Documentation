package src.Recursion10.Recursion2_level1;

//Sum of numbers from n to 1
public class SumOfNto1_3 {
    public static void main(String[] args) {
        //Sum of numbers from n to 1
        System.out.println(sum(6));
    }

    static int sum(int n){
        if (n==1 || n==0){
            return 1;
        }

        return n + sum(n-1);
    }

}
