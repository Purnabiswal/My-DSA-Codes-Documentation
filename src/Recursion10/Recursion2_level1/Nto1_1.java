package src.Recursion10.Recursion2_level1;

public class Nto1_1 {
    public static void main(String[] args) {
        fun(6);
        System.out.println();
        funRev(6);
        System.out.println();
        funBoth(6);
    }

    static void fun(int n){
        if (n==0){
            return;
        }
        System.out.print(n+" ");
        fun(n-1);
    }

    static void funRev(int n){
        if (n==0){
            return;
        }
        funRev(n-1);
        System.out.print(n+" "); //printing while the calls are returning
    }

    static void funBoth(int n){
        if (n==0){
            return;
        }
        System.out.print(n+" "); //printing while the calls are ongoing
        funBoth(n-1);
        System.out.print(n+" "); //printing while the calls are returning
    }
}
