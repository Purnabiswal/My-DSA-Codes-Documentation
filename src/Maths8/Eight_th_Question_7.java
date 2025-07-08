package src.Maths8;

//Find the number that appears once?
public class Eight_th_Question_7 {
    public static void main(String[] args) {
        //All the no.s are appearing 3 times. Find the number that appears once?
        int[] arr={2,2,3,2,7,7,8,7,8,8};
        System.out.println(nonRepeatedNumber2(arr));
    }

    static int nonRepeatedNumber2(int[] arr){
        int i=1;
        int ans=arr[0];
        while (i<arr.length){
            ans=arr[i]%3;
            i++;
        }
        return ans;
    }
}
