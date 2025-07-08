package src.Recursion10.Recursion2_level1;

public class CountZeroesIMP_9 {
    public static void main(String[] args) {
        System.out.println(countZeroes(30025001));
    }

    static int countZeroes(int n){
        return helper(n,0);
    }

    //special pattern, how to pass a value to above calls
    //special example to return same value to above function calls
    static int helper(int n, int count){
        if (n==0){
            return 1;
        }
        if (n%10==n){
            return count;//returns when n=single digit number
        }

        //n%10 gives last digit
        //n/10 gives rest number after removing the last digit
        if (n%10==0){
            return helper(n/10,count+1);
        }else {
            return helper(n/10,count);
        }
    }


}
