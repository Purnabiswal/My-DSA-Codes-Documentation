package src.Top150;

public class TP_15_LC_58_LengthOfLastWord {
    public static void main(String[] args) {
//        String s = "Hello World";
//        String s = "   fly me   to   the moon  ";
        String s = "luffy is still joyboy";

        System.out.println(lengthOfLastWord(s));
    }

    static public int lengthOfLastWord(String s) {
        char[] chars=s.toCharArray();
        int n=chars.length;
        int i = n-1;
        int count=0;
        //skip spaces
        while ( i >= 0 && chars[i]==' ') {
            i--;
        }
        //continue till space
        while (i>=0 && chars[i]!=' '){
            count++;
            i--;
        }
        return count;
    }

}
