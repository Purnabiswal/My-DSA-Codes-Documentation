package src.Recursion10.Recursion7_Backtracking;

import java.util.ArrayList;
import java.util.List;


public class MazeProblems {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        System.out.println(maze2( "", 3, 3, new ArrayList<>()));
        System.out.println(pathRet( "", 3, 3, new ArrayList<>()));
        System.out.println(pathRet( "", 3, 3));
        System.out.println(pathDiagonal( "", 3, 3));
    }


    //Q-1:
    // You can go right or down
    //Return path count only
    static int count(int r, int c){
        //Base case
        if (r==1 || c==1){
            return 1;
        }
        return count(r-1, c)+ count(r,c-1);
    }

    //Q-2:
    // You can go right or down
    //Return paths
    //Way-1
    static List<String> maze2(String p, int r, int c, List<String> list){
        if (r==1 || c==1){
            int len;
            char ch;
            if (r==1){
                len=c;
                ch='R';
            }else {
                len=r;
                ch='D';
            }
            p = p + String.valueOf(ch).repeat(Math.max(0, len - 1));
            list.add(p);
            return list;
        }

        maze2(p+'D', r-1, c, list);
        maze2(p+'R', r, c-1, list);

        return list;
    }
    //Way-2
    static List<String> pathRet(String p, int r, int c, List<String> list){
        if (r==1 && c==1){
            list.add(p);
            return list;
        }
        if (r>1){
            pathRet(p+'D', r-1, c, list);
        }
        if (c>1){
            pathRet(p+'R', r, c-1, list);
        }
        return list;
    }
    //Way-3
    //list in body
    static List<String> pathRet(String p, int r, int c){
        List<String> list = new ArrayList<>();
        if (r==1 && c==1){
            list.add(p);
            return list;
        }
        if (r>1){
            list.addAll(pathRet(p+'D', r-1, c));
        }
        if (c>1){
            list.addAll(pathRet(p+'R', r, c-1));
        }
        return list;
    }

    //Q-3:
    // You can go right or down or diagonal
    static List<String> pathDiagonal(String p, int r, int c){
        List<String> list = new ArrayList<>();
        if (r==1 && c==1){
            list.add(p);
            return list;
        }
        if (r>1){
            list.addAll(pathDiagonal(p+'V', r-1, c));
        }
        if (r>1 && c>1){
            list.addAll(pathDiagonal(p+"D", r-1, c-1));
        }
        if (c>1){
            list.addAll(pathDiagonal(p+'H', r, c-1));
        }
        return list;
    }



}
