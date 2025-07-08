package src.Maths8;

//Question  16
//Find XOR of numbers from 0 to a
public class XOROfNumbersInRange_16 {
    public static void main(String[] args) {

        int a=3;
        int b=4;
        int ans=xor(b)^xor(a-1);
        System.out.println(ans);

        //Only for check, will give TLE for large numbers
        int ans2=0;
        for (int i=a;i<=b;i++){
            ans2 ^=i;
        }
        System.out.println(ans2);

    }

    //XOR 0 to a
    static int xor(int a){
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
