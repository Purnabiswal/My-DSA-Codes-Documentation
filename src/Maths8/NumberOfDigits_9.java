package src.Maths8;

//Find number of bits in base b
public class NumberOfDigits_9 {
    public static void main(String[] args) {
        int n=8222;
        int b=2;
        System.out.println(((int)(Math.log(n)/Math.log(b))+1));
    }
}
