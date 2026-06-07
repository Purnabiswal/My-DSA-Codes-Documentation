package src.Top150;

public class TP_16_LC_14_Longest_Common_Prefix {
    public static void main(String[] args) {

//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix(strs));

    }

    static public String longestCommonPrefix(String[] strs) {
        StringBuilder ans= new StringBuilder();
        char[] s=strs[0].toCharArray();
        for (int i = 0; i < s.length; i++) {
            char ch=s[i];
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length()<=i || strs[j].charAt(i)!=ch){
                    return ans.toString();
                }
            }
            ans.append(ch);
        }
        return ans.toString();
    }


}
