package src.Maths8;

public class Power_12 {
    public static void main(String[] args) {
        int base=2;
        int power=4;
        System.out.println(power(base,power));
    }

    static int power(int base, int power){
        int ans=1;
        while(power>0){
            if ((power&1)==1){
                ans=ans*base;
            }

            base*=base;
            power=power>>1;
        }
        return ans;
    }

}
