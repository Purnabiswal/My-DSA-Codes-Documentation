package src.StringsAndStringBulider;


//String stores values in string pool(it's a particular part for string only)
//String is immutable

public class Main {
    public static void main(String[] args){
        String a="Purna";
        String b="Purna"; //if "a" and "b" are same, then they both will point to same object, so need to create an extra object for new variable of same values
        a="biswal"; //But changing value in "a" will not change the value in "b", it will create another object for "a"
        //Thus "String" is Immutable
        System.out.println(a);
        System.out.println(b);


        //Proof they are equal
        String x="abc";
        String y="abc";

        System.out.println(x==y); //"=="(it's a comparator) method checks if reference variable are pointing to same object


        //How to create diff objects of sane value?
        String p=new String("Purna");
        String q=new String("Purna");//creating the value outside the pool but in heap

        System.out.println(p==q); //this will give "false"
        //when you only need to check values, use .equals method
        System.out.println(p.equals(q)); //this will give "true"

        System.out.println(p.charAt(0)); //it's act like a character array but, it's not a char array. You can't do like p[0].

    }
}
