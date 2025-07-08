package src.Recursion10.Recursion5_SubsequenceAndStrings;

//Subsets, Subsequence And Strings

//Note: up=unprocessed, p=processed
public class SubsequenceAndStrings_1 {
    public static void main(String[] args) {
        SubsequenceAndStrings_1 ob=new SubsequenceAndStrings_1();

        //Remove all 'a' of a using recursion
        String str="baccad";

//        System.out.println(ob.remove(str)); //Output: bccd
//        ob.remove(str);
//        System.out.println(str); //Output: baccad , Because Strings are immutable in java
        //Note: Strings are immutable so you have store it before printing as string will not be changed by changing it in any function
        //Original string will remain as it is


        //System.out.println(ob.remove1(str));
        System.out.println(ob.removeApple("bcdapplefg"));
        System.out.println(ob.removeApp("bcdapplefgapp"));


        //Another way:
        //str1=str.replace("a","");
        //System.out.println(str1);

    }
    //Remove a part of string "app" from an entire string if it is not a part of substring "apple"
    //Q3
    String removeApp(String str){
        //base case
        if (str.isEmpty()){
            return ""; //Always return body string
        }
        if (!str.startsWith("apple") && str.startsWith("app")) {
            return removeApp(str.substring(3));
        }
        return str.charAt(0)+removeApp(str.substring(1));
    }


    //Remove a part of string "apple" from an entire string
    //Q2
    String removeApple(String str){
        //base case
        if (str.isEmpty()){
            return ""; //Always return body string
        }
        if (str.startsWith("apple")){
            return removeApple(str.substring(5));
        }
        return str.charAt(0)+removeApple(str.substring(1));
    }

    //Remove 'a' without taking any argument
    //Way-1:
    //Q1
    String remove1(String str){
        String str1="";
        //base case
        if (str.isEmpty()){
            return str1; //Always return body string
        }
        char ch=str.charAt(0);
        if (ch!='a'){
            str1=str1+ch; //This will only contain Current string
        }
        return str1+remove1(str.substring(1)); //Add the returning string value to the current string value and
                                        // return the current string (here str1)
    }



    //Remove 'a' without taking any argument
    //Way-2:
    //Q1
    String remove(String str){
        String str1="";
        return helper(str, str1);
    }
    String helper(String p, String up){
        //base case
        if(p.isEmpty()){
            p=up;
            return p;
        }
        if(p.charAt(0)!='a'){
            up=up+p.charAt(0);
        }
        p=p.substring(1);
        return helper(p,up);
    }


}





