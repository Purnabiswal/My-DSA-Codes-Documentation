package src.Maths8;

public class OddEven_1 {
    public static void main(String[] args) {
        System.out.println(oddOrEven(1013));
    }

    static String oddOrEven(int n){

        if ((n& 1)==1) {
            return "Odd";
        }

        return "Even";
    }
}
