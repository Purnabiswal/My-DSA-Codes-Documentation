package src.StackAndQueue_12.Questions;

import java.util.Stack;

public class ValidParentheses_LC20 {
    public static void main(String[] args) {
//        int a='('+0;
//        int b=')'+0;
//        int c='{'+0;
//        int d='}'+0;
//        int e='['+0;
//        int f=']'+0;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(e);
//        System.out.println(f);

        //System.out.println(isValid("[]()"));
    }


    static public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        stack.push('1');
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i);
            char cur=switch (ch) {
                case ')' -> '(';
                case '}' -> '{';
                case ']' -> '[';
                default -> '0';
            };
            if (cur==stack.peek()){
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        return stack.peek() == '1';
    }

    static public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('1');
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i);
            char cur=switch (ch) {
                case ')' -> '(';
                case '}' -> '{';
                case ']' -> '[';
                default -> '0';
            };
            if (cur==stack.peek()){
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        return stack.peek() == '1';
    }

}
