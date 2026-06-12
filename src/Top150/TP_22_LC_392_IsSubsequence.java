package src.Top150;

public class TP_22_LC_392_IsSubsequence {
    public static void main(String[] args) {
//        String s = "abc", t = "ahbgdc";
        String s = "axc", t = "ahbgdc";

        System.out.println(isSubsequence(s,t));
    }


    static public boolean isSubsequence(String s, String t) {
        int n=t.length();
        int m=s.length();
        if(m==0) return true;

        for (int i = 0; i < n; i++) {
            int j=i,k=0;
            if (t.charAt(j)==s.charAt(k)){
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
