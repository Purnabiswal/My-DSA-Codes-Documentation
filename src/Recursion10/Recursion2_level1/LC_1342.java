package src.Recursion10.Recursion2_level1;

public class LC_1342 {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
    }
    static int numberOfSteps(int num) {
        return helper(num,0);
    }

    //to pass "step" variable value in every func call, we have to pass "step" in argument
    //to get another argument in recursion we use helper func
    static int helper(int n, int steps){
        if(n==0){
            return steps;
        }

        if (n%2==0){
            //even
            return helper(n/2,steps+1);
        }
        return helper(n-1,steps+1);
    }
}
