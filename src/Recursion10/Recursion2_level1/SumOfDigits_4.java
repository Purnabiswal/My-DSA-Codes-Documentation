package src.Recursion10.Recursion2_level1;

public class SumOfDigits_4 {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(-23));
    }

    static int sumOfDigits(int n){

        if (n/10<=0){
            return n;
        }

        return n%10+sumOfDigits(n/10);
    }
}
