package src.StackAndQueue_12.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//Hackerrank
public class GameOf2Stacks_HK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input maxSum
        System.out.print("Enter max sum: ");
        int maxSum = sc.nextInt();

        // Input size of list a
        System.out.print("Enter number of elements in list a: ");
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        System.out.println("Enter elements of list a:");
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        // Input size of list b
        System.out.print("Enter number of elements in list b: ");
        int m = sc.nextInt();
        List<Integer> b = new ArrayList<>();
        System.out.println("Enter elements of list b:");
        for (int i = 0; i < m; i++) {
            b.add(sc.nextInt());
        }

        System.out.println("List a: " + a);
        System.out.println("List b: " + b);
        System.out.println("Result: " + twoStacks(maxSum, a, b));
    }
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        return twoStacks(maxSum, a, b, 0, 0);
    }
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b, int sum, int count) {
        // Write your code here
        if (sum>maxSum){
            return count-1;
        }
        if (sum==maxSum){
            return count;
        }
        int ans1=count, ans2=count;

        if (!a.isEmpty()){
            int removed1=a.remove(0);
            ans1 = twoStacks(maxSum, a, b, sum+removed1, count+1);
            a.add(0, removed1);
        }
        if (!b.isEmpty()){
            int removed2=b.remove(0);
            ans2 = twoStacks(maxSum, a, b, sum+removed2, count+1);
            b.add(0, removed2);
        }

        return Math.max(ans1, ans2);
    }
}
