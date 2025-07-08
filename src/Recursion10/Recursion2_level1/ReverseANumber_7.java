package src.Recursion10.Recursion2_level1;

public class ReverseANumber_7 {


    static int sum=0;//Taking outside because if we take inside sum=0 then, when recursion calls it will always be updated to 0

    static void reverse(int n){
        if (n==0){
            return;
        }

        int remainder=n%10;
        sum=sum*10+remainder;

        reverse(n/10);
    }

    static int reverse1(int n){
        //sometimes you might need some additional variables in the argument
        //in that case, make another function
         int digits=(int)(Math.log(n)/Math.log(10))+1;

        return helper(n, digits);
    }

    static int helper(int n, int arg){
        if (n%10 == n){
            return n;
        }
        return (n%10) * (int)Math.pow(10,arg-1) +helper(n/10,arg-1);
    }

    public static void main(String[] args) {
//        reverse(1342);
//        System.out.println(sum);

        System.out.println(reverse1(1342));
    }
}
