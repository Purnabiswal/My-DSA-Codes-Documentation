package src.StackAndQueue_12.Questions;

import java.util.Objects;
import java.util.Stack;

public class LC_1541 {
    public static void main(String[] args) {
        //System.out.println(minInsertions2("(((()(()((())))(((()())))()())))(((()(()()((()()))"));
        //System.out.println(minInsertions1("(((()(()((((((()(()()(("));
        System.out.println(minInsertions2("(()))"));
        System.out.println(minInsertions3("(()))"));
        System.out.println(minInsertions("(()))"));
    }

    //Efficient one
    static public int minInsertions(String s) {
        char[] arr=s.toCharArray();
        char ch;
        int count=0;
        int top=0;
        int n=s.length();
        for (int i = 0; i < n; i++) {
            ch=arr[i];
            if (ch=='('){
                top++;
            }else {
                if (i+1!=n && arr[i+1]==')'){
                    i++;
                }else {
                    count++;
                }
                if (top!=0){
                    top--;
                }else {
                    count++;
                }
            }
        }
        return count+(2*(top));
    }

    //Efficient one
    static public int minInsertions1(String s) {
        char[] stack = new char[s.length()];
        char ch;
        int count=0;
        int top=0;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i);
            if (ch=='('){
                stack[top++]=ch;
                //stack.push(ch);
            }else {
                if (i+1!=s.length() && s.charAt(i+1)==')'){
                    i++;
                }else {
                    count++;
                }
                if (top!=0){
                    top--;
                    //stack.pop();
                }else {
                    count++;
                }
            }
        }
        return count+(2*(top));
    }

    //Good one
    static public int minInsertions2(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i);
            if (ch=='('){
                stack.push(ch);
            }else {
                if (i+1!=s.length() && s.charAt(i+1)==')'){
                    i++;
                }else {
                    count++;
                }
                if (!stack.isEmpty()){
                    stack.pop();
                }else {
                    count++;
                }
            }
        }
        return count+(2*stack.size());
    }


    //slower one but correct output
    static public int minInsertions3(String s) {
        Stack<String> stack = new Stack<>();
        String ch;
        String ch2;
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i)+"";
            if (i !=s.length()-1){
                ch2 = ch+s.charAt(i+1);
            }else {
                ch2=ch;
            }

            if (ch2.equals("))")){
                if (!stack.isEmpty()){
                    stack.pop();
                }else {
                    count++;
                }
                i++;
            }else if(ch.equals(")")){
                count++;
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    count++;
                }
            }else {
                stack.push(ch);
            }
        }

        return count+(2*stack.size());
    }

    //wrong output
    static public int minInsertions4(String s) {
        Stack<String> stack = new Stack<>();
        char ch;
        String ch2;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i);
            if (i==s.length()-1){
                stack.push(ch+"");
                break;
            }
            ch2=ch+""+s.charAt(i+1);
            if (ch2.equals("))")){
                if (!stack.isEmpty() && Objects.equals(stack.peek(), "(")){
                    stack.pop();
                }else {
                    stack.push(ch2);
                }
                i++;
            }else {
                stack.push(ch+"");
            }
        }
        //return check(stack, "(((()(()((((((()(()()((");
        int cost=0;
        String e;
        String x;
        while(!stack.isEmpty()){
            e=stack.pop();
            if (!stack.isEmpty() && (stack.peek()+e).equals("()")){
                cost++;
                stack.pop();
            }else if (e.equals("))")){
                cost++;
            }else {
                cost+=2;
            }
        }
        return cost;
    }





}
