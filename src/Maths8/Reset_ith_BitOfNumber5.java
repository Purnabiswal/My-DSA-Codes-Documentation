package src.Maths8;

public class Reset_ith_BitOfNumber5 {
    public static void main(String[] args) {
        System.out.println(setIthBit(182,4));
    }
    static int setIthBit(int num,int n){
        int ans=~(1<<n);
        return num & ans;
    }
}
