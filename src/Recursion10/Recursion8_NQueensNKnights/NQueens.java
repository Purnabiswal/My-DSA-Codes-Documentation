package src.Recursion10.Recursion8_NQueensNKnights;

public class NQueens {
    public static void main(String[] args) {
        int n=5;
        boolean[][] board=new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    //True means queen is present
    //TC: O(N!)
    static int queens(boolean[][] board, int r){
        if (r>= board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        for (int col = 0; col < board.length; col++) {
            //Place the queen if it is safe
            if (isSafe(board, r, col)){
                board[r][col]=true;
                count+=queens(board, r+1);
                board[r][col]=false;
            }
        }
        return count;
    }

    static void display(boolean[][] board){
        for(boolean[] e: board){
            for(boolean element : e){
                if (element){
                    System.out.print("Q ");
                }else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][] board, int r, int c){
        //Check vertical row
        for (int i = 0; i <= r; i++) {
            if (board[i][c]){
                return false;
            }
        }
        //Check Diagonal left
        for (int i = 1; i <= Math.min(r, c); i++) {
            if (board[r-i][c-i]){
                return false;
            }
        }
        //Check Diagonal right
        for (int i = 1; i <= Math.min(r, board.length - c-1); i++) {
            if (board[r-i][c+i]){
                return false;
            }
        }
        return true; //true means safe to place
    }
}
