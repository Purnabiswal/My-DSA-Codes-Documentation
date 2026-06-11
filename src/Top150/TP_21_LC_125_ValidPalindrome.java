package src.Top150;

public class TP_21_LC_125_ValidPalindrome {
    public static void main(String[] args) {
//        String s="A man, a plan, a canal: Panama";
        String s="race a car";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome2(s));
    }


    //Way-3: Efficient
    static public boolean isPalindrome3(String s) {

        int left=0;
        int right=s.length()-1;

        while (left<right){
            char left_ch=s.charAt(left);
            if ( !Character.isLetterOrDigit(left_ch)){
                left++;
                continue;
            }
            char right_ch = s.charAt(right);
            if ( !Character.isLetterOrDigit(right_ch)){
                right--;
                continue;
            }

            if (Character.toLowerCase(left_ch)!=Character.toLowerCase(right_ch)) return false;
            left++;
            right--;
        }

        return true;
    }

    //Way-2: Efficient
    static public boolean isPalindrome2(String s) {
        char[] chars=s.toLowerCase().toCharArray();
        int n= chars.length;

        int left=0;
        int right=n-1;

        while (left<right){
            char left_ch=chars[left];
            if ( !(left_ch>='a' && left_ch<='z' || (left_ch>='0' && left_ch<='9'))){
                left++;
                continue;
            }
            char right_ch = chars[right];
            if ( !((right_ch >='a' && right_ch <='z') || (right_ch>='0' && right_ch<='9'))){
                right--;
                continue;
            }

            if (chars[left]!=chars[right]) return false;
            left++;
            right--;
        }

        return true;
    }



    //Way-1
    static public boolean isPalindrome(String s) {
        char[] chars=s.toLowerCase().toCharArray();
        int n= chars.length;
        StringBuilder clean_str=new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch=chars[i];
            if (ch>='a' && ch<='z' || (ch>='0' && ch<='9')){
                clean_str.append(ch);
            }
        }

        int m=clean_str.length();
        for (int i = 0; i < m/2; i++) {
            if (clean_str.charAt(i)!=clean_str.charAt(m-i-1)){
                return false;
            }
        }

        return true;
    }

}
