package src.Maths8;

public class Set_ith_BitOfNumber4 {
    public static void main(String[] args) {
        System.out.println(setIthBit(182,6));
    }
    static int setIthBit(int num,int n){
        return num | 1<<n;
    }
}
