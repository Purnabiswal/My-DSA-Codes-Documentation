package src.Maths8;

import java.util.Scanner;

//Find the given no. is a power of 2 or not.
public class Question12_11 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter number: ");
        int n=scan.nextInt();
        System.out.println(solution(n));//note: fix for n=0
    }

    //Way-1:
    static boolean solution(int n){
        if((n &(n-1))==0 && n>0){
            return true;
        }
        return false;
    }

    //Way-2:
    static boolean solution2(int n){
        int x=((int)(Math.log(n)/Math.log(2))+1);
        int y=(1<<(x-1));
        if((n &(~y))==0){
            return true;
        }
        return false;
    }

}
