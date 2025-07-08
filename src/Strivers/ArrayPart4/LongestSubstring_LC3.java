package src.Strivers.ArrayPart4;

public class LongestSubstring_LC3 {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }
    static public int lengthOfLongestSubstring(String s) {
        int counter=0;
        int longest=0;
        StringBuilder str=new StringBuilder();

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(str.toString().contains(""+s.charAt(j))){
                    longest=Integer.max(longest,counter);
                    counter=0;
                    str.setLength(0);
                    break;
                }
                str.append(s.charAt(j));
                counter++;
            }
        }

        longest=Integer.max(longest,counter);
        return longest;
    }
}
