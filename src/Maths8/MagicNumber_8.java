package src.Maths8;

//TC : log(n)
public class MagicNumber_8 {
    public static void main(String[] args) {
        System.out.println(findMagicNumber2(6));
    }

    static int findMagicNumber(int n){
        int ans=0;
        int i=1;

        while (n!=0){
            ans= ans+(int)((n & 1)*Math.pow(5,i++));
            n=n>>1;
        }
        return ans;
    }

    static int findMagicNumber2(int n) {
        int ans = 0;
        int base = 1;
        while (n != 0) {
            int last = n & 1;
            n >>= 1;
            base *= 5;
            ans += last * base;
        }
        return ans;
    }
}
