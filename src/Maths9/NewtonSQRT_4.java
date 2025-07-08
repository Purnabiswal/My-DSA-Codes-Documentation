package src.Maths9;

//Newton Raphson Method to find square root of a number
public class NewtonSQRT_4 {
    public static void main(String[] args) {

        System.out.println(sqrt(40));

    }

    static double sqrt(double n){

        double x=n;
        int counter=0;

        while(true){

            double root=0.5*(x+(n/x));



            double error=root-x;
            if (error<0){
                error =(error*(-1));   //To make this +ve
            }

            //another way
//            if (error<0){
//                error=Math.abs(error);
//            }

            if (error<0.5){ //you choose how much error you want like error<1 or error <0.1  . This error decides precised answer and how much times the loop will run
                //The less error you want the more the loop will runt
                System.out.println(counter);
                return root;

            }
            x=root;
            counter++;

        }

    }

}
