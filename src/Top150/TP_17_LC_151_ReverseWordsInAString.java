package src.Top150;

public class TP_17_LC_151_ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    static public String reverseWords(String s) {
        char[] chars=s.trim().toCharArray();
        StringBuilder sb=new StringBuilder();
        StringBuilder word=new StringBuilder();
        int n=chars.length;
        for (int i = n-1; i >= 0 ; i--) {
            if (chars[i]==' '){
                sb.append(word.reverse());
                word=new StringBuilder();
                sb.append(' ');
                i--;
            }
            while (chars[i]==' '){
                i--;
            }
            word.append(chars[i]);
        }
        sb.append(word.reverse());

        return sb.toString();
    }

}
