package src.Recursion10.Recursion4_PatternsAndSorting;

public class Patterns_1 {
    public static void main(String[] args) {
        pattern1(4);
        pattern2(4);
        pattern3(4);
    }
    static void pattern1(int n){
        //base case
        if (n==0){
            return;
        }
        helper(n);
        System.out.println();
        pattern1(n-1);
    }
    static void helper(int n){
        //base case
        if (n==0){
            return;
        }
        System.out.print("* ");
        helper(n-1);
    }

    static void pattern2(int n){
        helper2(n,n);
    }
    static void helper2(int r,int c){
        //base case
        if (r==0){
            return;
        }
        if (c==0){
            System.out.println();
            helper2(r-1,r-1);
            return;
        }
        System.out.print("* ");
        helper2(r,c-1);
    }


    //normal triangle
    static void pattern3(int n){
        helper3(n,n);
    }
    static void helper3(int r,int c){
        //base case
        if (r==0){
            return;
        }
        if (c==0){

            helper3(r-1,r-1);
            System.out.println();
            return;
        }
        helper3(r,c-1);
        System.out.print("* ");
    }


}
