package src.Maths8;

import java.math.BigInteger;

//Find number of set bits.
public class NumberOfSetBits_13 {
    public static void main(String[] args) {

        int n=186622222;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(totalSetBits(n));
        System.out.println(totalSetBits2(n));
        System.out.println(totalSetBits3(n));
        System.out.println(totalSetBits4(n));
    }

    //Way1:Best way
    //TC: log(n)
    static int totalSetBits(int n){
        int ans=0;
        int comparisons=0;
        while (n>0){
            ans++;
            n=(n&(n-1));//this will reset the right set bit position. Keep doing this until the number gets zero.
            comparisons++;
        }
        System.out.println("Loop ran "+comparisons+" times");
        return ans;
    }

    //Way2:
    //TC: log(n)
    static int totalSetBits2(int n){
        int ans=0;
        int setBit;
        int comparisons=0;
        while (n>0){
            ans++;
            n=n-(n&(-n));//this will reset the right set bit position. Keep doing this until the number gets zero.
            comparisons++;
        }
        System.out.println("Loop ran "+comparisons+" times");
        return ans;
    }


    //Way3:
    //TC: log(n)
    static int totalSetBits3(int n){
        int ans=0;
        int setBitPosition;
        int comparisons=0;
        while (n>0){
            setBitPosition=(int)(Math.log(n&(-n))/Math.log(2));
            ans++;
            n=n&(~(1<<setBitPosition));//Reset the set bit position.
            comparisons++;
        }

        System.out.println("Loop ran "+comparisons+" times");
        return ans;
    }




    //Way4:
    //TC: O(n)
    static int totalSetBits4(int n){
        int comparisons=0;
        int ans=0;
        while (n>0){
            if ((n&1)==1){
                ans++;
            }
            n=n>>1;
            comparisons++;
        }

        System.out.println("Loop ran "+comparisons+" times");
        return ans;
    }
}
