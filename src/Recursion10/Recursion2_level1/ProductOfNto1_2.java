package src.Recursion10.Recursion2_level1;

public class ProductOfNto1_2 {
    public static void main(String[] args) {
        System.out.println(fact(0));
    }

    static int fact(int n){
        if (n==1 || n==0){
            return 1;
        }

        return n* fact(n-1);
    }

}
