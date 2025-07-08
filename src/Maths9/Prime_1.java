package src.Maths9;

//Check whether prime or not
public class Prime_1 {
    public static void main(String[] args) {
        int n=20;

        for (int i = 1; i <= n; i++) {
            System.out.println(i+" "+isPrime(i));
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.println(i+" "+isPrime2(i));
        }



    }
    static boolean isPrime(int n){
        if (n<=1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    //Without using Math.sqrt function
    static boolean isPrime2(int n){
        if (n<=1){
            return false;
        }
        int i=2;
        while (i*i<=n){
            if (n%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
}
