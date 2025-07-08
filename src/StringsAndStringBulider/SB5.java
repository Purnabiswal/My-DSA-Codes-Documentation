package src.StringsAndStringBulider;

//String Builder:
public class SB5 {
    public static void main(String[] args) {
        StringBuilder builder=new StringBuilder(); //StringBuilder is mutable but string is immutable

        for (int i=0;i<26;i++){
            char ch=(char) ('a'+i);
            builder.append(ch); //No new objects are created in each iteration
        }

        System.out.println(builder);
        //System.out.println(builder.reverse());

        System.out.println(builder.indexOf("j"));

        System.out.println(builder.repeat("a",4)); //due to mutability whole string is changed
        System.out.println(builder); //mutability




    }
}
