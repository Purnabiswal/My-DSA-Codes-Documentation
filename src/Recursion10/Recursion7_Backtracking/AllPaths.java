package src.Recursion10.Recursion7_Backtracking;

import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] arr=new int[3][3];

        //allPath("", maze, 0, 0);
        allPathWithMaze("", arr, 0, 0, 1);
    }

    //Q-5
    //Print all paths. You can go up, down, right, left
    static void allPath(String p, boolean[][] maze, int r, int c){
        //Base case
        if (r== maze.length-1 && c== maze[0].length-1){
            System.out.println(p);
            return;
        }
        if (!maze[r][c]){
            return;
        }
        //Check for river
//        if (!maze[r][c]){
//            return;
//        }

        //I am considering this block in my path, So I am marking this as false
        maze[r][c]=false;

        if (r< maze.length-1){
            allPath(p+'D', maze, r+1, c);
        }
        if (r>0){
            allPath(p+'U',maze,r-1, c);
        }
        if (c>0){
            allPath(p+'L',maze,r, c-1);
        }
        if (c< maze[0].length-1){
            allPath(p+'R', maze, r, c+1);
        }

        //At this line the function will be over
        //So before the function gets remove from stack, also remove the changes that were made by that function
        maze[r][c]=true;
    }

    //Q-6:
    //Print the maze with the path
    static void allPathWithMaze(String p, int[][] maze, int r, int c, int step){
        //Base case
        if (r== maze.length-1 && c== maze[0].length-1){
            maze[r][c]=step;
            System.out.println(p);
            for (int[] e:maze){
                System.out.println(Arrays.toString(e));
            }
            System.out.println();
            return;
        }
        if (maze[r][c]!=0){
            return;
        }
        //I am considering this block in my path, So I am marking this as false
        maze[r][c]=step;

        if (r< maze.length-1){
            allPathWithMaze(p+'D', maze, r+1, c, step+1);
        }
        if (r>0){
            allPathWithMaze(p+'U',maze,r-1, c, step+1);
        }
        if (c>0){
            allPathWithMaze(p+'L',maze,r, c-1, step+1);
        }
        if (c< maze[0].length-1){
            allPathWithMaze(p+'R', maze, r, c+1, step+1);
        }

        //At this line the function will be over
        //So before the function gets remove from stack, also remove the changes that were made by that function
        maze[r][c]=0;
    }
    //Arrays in java are changed in all func calls if you change them in one func call, so we have to use backtracking while returning.
    //But for any integer (like 'step' in above func) we don't have to backtrack

}
