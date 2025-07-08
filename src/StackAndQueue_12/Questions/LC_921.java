package src.StackAndQueue_12.Questions;

import java.util.Stack;

public class LC_921 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid2("())"));
    }

    //Good one
    static public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i);
            if (!stack.isEmpty() && ch==')' && stack.peek()=='('){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

    //Efficient one
    static public int minAddToMakeValid2(String s) {
        char[] stack = new char[s.length()];
        char ch;
        int top=-1;
        for (int i = 0; i < s.length(); i++) {
            ch=s.charAt(i);
            if (top!=-1 && ch==')' && stack[top]=='('){
                top--;
            }else {
                stack[++top]=ch;
            }
        }
        return top+1;
    }
}
