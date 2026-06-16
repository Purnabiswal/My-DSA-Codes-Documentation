package src.Top150;

public class TP_22_LC_392_IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
//        String s = "axc", t = "ahbgdc";

        System.out.println(isSubsequence(s,t));

        System.out.println(isSubsequence2(s,t));
    }

    //Efficient One:
    static public boolean isSubsequence2(String s, String t) {
        if(s.isEmpty()) return true;

        int j=0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i)==s.charAt(j)){
                if (j==s.length()-1) return true;
                j++;
            }

        }

        return false;
    }

    //Inefficient: Not a good approach
    static public boolean isSubsequence(String s, String t) {
        int n=t.length();
        int m=s.length();
        if(m==0) return true;

        for (int i = 0; i < n; i++) {
            int j=i,k=0;
            if (t.charAt(j)==s.charAt(k)){
                // Below while loop is unnecessary
                while (j<n && k<m){
                    if (t.charAt(j)==s.charAt(k)){
                        j++;
                        k++;
                    }else {
                        j++;
                    }
                }
            }

            if (k==m){
                return true;
            }
        }

        return false;
    }

}
