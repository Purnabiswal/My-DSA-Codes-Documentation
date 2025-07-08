package src.Recursion10.Recursion7_Backtracking;

import java.util.Arrays;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        pathRestriction("", maze, 0, 0);
    }

    //Q-4
    //At (2,2) path is restricted, represented as false in maze matrix
    static void pathRestriction(String p, boolean[][] maze, int r, int c){
        //Base case
        if (r== maze.length-1 && c== maze[0].length-1){
            System.out.println(p);
            return;
        }
        //Check for river
        if (!maze[r][c]){
            return;
        }

        if (r< maze.length-1){
            pathRestriction(p+'D', maze, r+1, c);
        }
        if (c< maze[0].length-1){
            pathRestriction(p+'R', maze, r, c+1);
        }
    }
}
