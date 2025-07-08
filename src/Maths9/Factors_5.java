package src.Maths9;

import java.util.ArrayList;

public class Factors_5 {
    public static void main(String[] args) {
        //factors1(20);
        factors3(36);
    }

    //way-1:
    //TC: O(n)
    static void factors1(int n){
        for (int i = 1; i <= n / 2; i++) {
            if (n%i==0){
                System.out.println(i);
            }
        }
        System.out.println(n);
    }

    //Best way, but the printing is not sorted manner
    //way-2:
    //TC: O(sqrt(n))
    static void factors2(int n){
        for (int i = 1; i*i <=n ; i++) {
            if (n%i==0){
                if (n/i==i){
                    System.out.print(i+" ");
                }else {
                    System.out.print(i+" "+n/i+" ");
                }
            }
        }
    }

    //way-3:
    //both time and space will be O(sqrt(n))
    static void factors3(int n){

        ArrayList<Integer> list=new ArrayList<>();


        for (int i = 1; i*i <=n ; i++) {
            if (n%i==0){
                if (n/i==i){
                    System.out.print(i+" ");
                }else {
                    System.out.print(i+" ");
                    list.add(n/i); //Adding the numbers that multiple of i which is printed above
                }
            }
        }

        //As the numbers are added in descending order, that's why printing in reverse order
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i)+" ");
        }

    }


}
