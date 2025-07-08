package src.LinkedList11.Questions;

public class LC_202_HappyNumbers {
    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }
    static public boolean isHappy(int n) {
        int fast=n;
        int slow=n;

        while(true){
            slow=square(slow);
            fast=square(fast);
            fast=square(fast);
            if(fast==1 || slow==1){
                return true;
            }
            if(fast==slow){
                return false;
            }

        }
    }
    static public int square(int n){
        int sum=0;
        int x;
        while(n!=0){
            x=n%10;
            sum+=x*x;
            n/=10;
        }
        return sum;
    }
}

