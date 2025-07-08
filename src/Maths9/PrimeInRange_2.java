package src.Maths9;

//TC: n*log(log(n))
public class PrimeInRange_2 {
    public static void main(String[] args) {
        int n=37;
        boolean[] arr=new boolean[n+1];
        primeNumbers(n,arr);

    }

    //Sieve of Eratosthenes
    static void primeNumbers(int n, boolean[] primes){
        int i=2;
        while(i*i<=n){
            if (!primes[i]){
                for(int j=i*2;j<=n;j=i+j){
                    primes[j]=true;
                }
            }
            i++;
        }

        for(int i1 = 2; i1 <=n; i1++){
            if (!primes[i1]){
                System.out.print(i1+" ");
            }
        }

    }
}
