package src.Recursion10.Recursion2_level1;

public class ProductOfDigits_5 {
    public static void main(String[] args) {
        System.out.println(productOfDigits(50253));
    }

    static int productOfDigits(int n){

        if (n/10<=0){
            return n;
        }

        return n%10 * productOfDigits(n/10);
    }
}
