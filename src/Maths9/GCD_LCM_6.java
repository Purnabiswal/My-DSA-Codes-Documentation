package src.Maths9;

public class GCD_LCM_6 {
    public static void main(String[] args) {

        int a=2;
        int b=7;

        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }

    static int gcd(int a, int b){
        if (a==0){
            return b;
        }
        return gcd(b%a,a);
    }

    static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
}
