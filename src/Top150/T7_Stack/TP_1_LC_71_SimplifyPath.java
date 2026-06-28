package src.Top150.T7_Stack;

import java.util.Stack;

public class TP_1_LC_71_SimplifyPath {
    public static void main(String[] args) {

//        String path = "/.../a/../b/c/../d/./";
        String path = "/../";
//        String path = "/a/../../b/../c//.//";

        System.out.println(simplifyPath(path));

    }


    static public String simplifyPath(String path) {
        int n=path.length();
        Stack<String> stack=new Stack<>();
        stack.push("/");
        for (int i = 1; i < n; i++) {
            if (path.charAt(i)=='/') continue;
            int j=i;
            StringBuilder sb=new StringBuilder();
            while (j<n && path.charAt(j)!='/'){
                sb.append(path.charAt(j));
                j++;
            }
            String e=sb.toString();
            if (e.equals(".")){

            } else if (e.equals("..")) {
                if (stack.size()!=1) {
                    stack.pop();
                    stack.pop();
                }
            }else {
                stack.push(e);
                stack.push("/");
            }

            i=j;
        }

        if (stack.size()!=1) stack.pop();

        StringBuilder sb=new StringBuilder();
        for (String e: stack){
            sb.append(e);
        }
        return sb.toString();

    }

}
