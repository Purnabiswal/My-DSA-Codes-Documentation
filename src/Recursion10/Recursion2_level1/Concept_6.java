package src.Recursion10.Recursion2_level1;

public class Concept_6 {
    public static void main(String[] args) {
        fun(5);
    }

    static void fun(int n){
        if (n==0){
            return;
        }

        System.out.println(n);
        //fun(n--); this will cause infinite calls, stack overflow occurs
        fun(--n); //this works fine
        // n-- vs --n are not same
    }
}
