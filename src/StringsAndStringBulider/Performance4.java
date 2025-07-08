package src.StringsAndStringBulider;

public class Performance4 {
    public static void main(String[] args) {
        String series="";
        for (int i=0;i<26;i++){
            char ch=(char) ('a'+i);
            series=series+ch;   // series += ch // In every iteration it will create new objects and add values to it, thus performance reduces. To overcome this we use StringBuilder
        }
        System.out.println(series);
    }
}
