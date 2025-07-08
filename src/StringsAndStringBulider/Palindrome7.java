package src.StringsAndStringBulider;


//Palindrome of a string
public class Palindrome7 {
    public static void main(String[] args) {
        String name="abba";
        System.out.println(palindrome(name));

    }

    static boolean palindrome(String str){

        if (str==null) {
            return true; //return as instructed
        }

        str=str.toLowerCase();
        int s=0;
        int e=str.length()-1;

        while(s<=e){
            if(str.charAt(s)==str.charAt(e)){
                s++;
                e--;
            }else {
                return false;
            }
        }
        return true;
    }
}
