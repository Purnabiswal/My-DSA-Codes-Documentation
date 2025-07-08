package src.Recursion10.Recursion1;

public class FibonacciNumbers4 {
    public static void main(String[] args) {
        //How to solve it with recursion?
        //1. Break it down into smaller problems.
        //2.
        //fib(5);
        System.out.println(fib(3));
    }

    static int fib(int n) {

        //base condition
        if(n<2){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}
