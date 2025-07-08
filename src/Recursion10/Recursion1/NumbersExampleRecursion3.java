package src.Recursion10.Recursion1;

public class NumbersExampleRecursion3 {
    public static void main(String[] args) {
        //write a  function that takes in a number nad prints it
        //print first 5 numbers: 1 2 3 4 5

        print(1);
    }

    //1. Recursion is basically means a function that calls itself.

    static void print(int n){

        //Base condition for recursion: Condition where our recursion will stop making new calls
        //Base condition
        if (n==5) {
            System.out.println(n);
            return;
        }

        //Body
        System.out.println(n);

        //recursive call
        //If you are calling a function again and again, you can treat it as a separate call in the stack
        //This is called tail recursion
        //This is the last function call
        print(n+1);
    }

}
