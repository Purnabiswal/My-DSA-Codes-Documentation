package src.Recursion10.Recursion2_level1;

public class Palindrome_8 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1));

        int x=12;
        String str= String.valueOf(x);
    }
    static boolean isPalindrome(int n){
        return n == rev(n);
    }

    static int rev(int n){
        int digits=(int) Math.log10(n)+1;

        return helper(n,digits);
    }

    static int helper(int n, int digits){
        if (n%10==n){
            return n;
        }

        return (n%10)*(int) Math.pow(10,digits-1)+helper(n/10,digits-1);
    }
}
