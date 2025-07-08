package src.Maths8;

//Question  15
//Find XOR of numbers from 0 to a
public class XOROfNumbers_14 {
    public static void main(String[] args) {

        System.out.println(xorOfNumbers(9));

    }

    //XOR 0 to a
    static int xorOfNumbers(int a){
        if (a%4==0){
            return a;
        } else if (a % 4 == 1) {
            return 1;
        }else if (a % 4 == 2) {
            return a+1;
        }else {
            return 0;
        }
    }

}
