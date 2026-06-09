package src.Top150;

public class TP_19_LC_28_FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";

        System.out.println(strStr(haystack, needle));
        System.out.println(strStr2(haystack, needle));

    }

    //Way-2: Efficient one
    static public int strStr2(String haystack, String needle) {
        int n= haystack.length(), m=needle.length();
        for (int i = 0; i < n; i++) {
            if ((m+i)<=n && haystack.substring(i, m+i).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    //Way-1
    static public int strStr(String haystack, String needle) {
        char[] hayStackArr=haystack.toCharArray();
        char[] needleArr=needle.toCharArray();
        int n= hayStackArr.length, m=needleArr.length;



        for (int i = 0; i < hayStackArr.length; i++) {

            int j=i, k=0;
            while (j<n && k<m){
                if (hayStackArr[j]==needleArr[k]){
                    j++;k++;
                    if (k==m) return i;
                    continue;
                }
                break;
            }

        }
        return -1;
    }
}
