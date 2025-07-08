package src.Maths9;


//TC: O(log(n))
public class SquareOfNumbers_3 {
    public static void main(String[] args) {
        System.out.println(squareRoot(40,2));
    }

    //Using Binary search to find square root of a number
    static double squareRoot(int n, int p){

        int s=1;
        int e=n;
        double root;
        int counter=0;

        while(s<e){
            int m=s+ (e - s) /2;
            if(m*m==n){
                System.out.println(counter);
                return m;
            } else if (m*m < n) {
                s=m+1;
            }else {
                e=m-1;
            }
            counter++;

        }
        root=s;
        double increment=0.1;
//        for (int i = 1; i < p*10; i++) {
//            root+= increment;
//            if (root*root>n){
//                root= root-increment;
//
//                if (i>=(p*10)-10){
//                    break;
//                }
//                i=10;
//                increment/=10;
//            }
//
//        }

        for (int i = 0; i < p; i++) {
            while (root*root<=n){
                root+=increment;
            }

            root -=increment;
            increment /= 10;
        }

        System.out.println(counter);
        return root;
    }
}
