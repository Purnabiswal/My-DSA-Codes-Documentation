package src.Maths8;

public class Find_ith_BitOfNumber3 {
    public static void main(String[] args) {
        System.out.println(ithBit(182,4));
    }
    static int ithBit(int num,int n){
        int ans=num & 1<<n;
        if (ans==0){
            return 0;
        }
        return 1;
    }
}
