package src.Maths8;

//find right most set bit
public class FindRightSetBit_6 {
    public static void main(String[] args) {
        System.out.println(rightSetBit(182));
    }

    //First method
    static int rightSetBit(int num){

        return (int)(Math.log(num & (-num))/ (Math.log(2)))+1;
    }


    //Second method
    static int rightSetBit2(int num){
        int i=0;
        while(true){
            if ((num & 1<<i)!=0){
                return i;
            }
            i++;
        }
    }


    //optimized solution of second method
//    static int rightSetBit(int num){
//        int i=0;
//        while((num & 1<<i)==0){
//            i++;
//        }
//        return i;
//    }
}
