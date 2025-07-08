package src.Maths8;

import java.util.Scanner;

//Find the sum of nth row in Pascal's Triangle
public class PascalTriangleSum_10 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter row number: ");
        int row=scan.nextInt();
        System.out.println("Sum is: "+(1<<(row-1)));

    }
}
