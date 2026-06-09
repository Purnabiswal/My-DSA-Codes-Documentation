package src.Top150;

public class TP_18_LC_6_ZigzagConversion {
    public static void main(String[] args) {
//        String s = "PAYPALISHIRING";
//        String s = "A";
        String s = "AB";
        int n=1;
        System.out.println(convert(s, n));

    }


    //Optimized solution
    static public String convert(String s, int numRows) {
        char[] chars=s.toCharArray();
        int len= chars.length;
        if(len==1 || numRows==1) return s;
        StringBuilder ans=new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j=i;
            int inc=(numRows-i-1)*2;
            int dec=i*2;
            if (i==0){
                dec=inc;
            } else if (i == numRows - 1) {
                inc=dec;
            }
            boolean isInc=true;
            while (j<len){
//                System.out.print(j+" ");
                ans.append(chars[j]);
                j+=(isInc)?inc:dec;
                isInc=!isInc;
            }
        }
//        System.out.println();
        return ans.toString();
    }

}
