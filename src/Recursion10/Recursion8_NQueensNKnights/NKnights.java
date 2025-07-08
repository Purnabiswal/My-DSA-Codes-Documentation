package src.Recursion10.Recursion8_NQueensNKnights;

public class NKnights {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board=new boolean[n][n];
        knights(board, 0, 0, 4);
    }
    static void knights(boolean[][] board, int r, int c, int N){

        if (N==0){
            display(board);
            System.out.println();
            return;
        }

        if (r==board.length-1 && c== board.length-1){
            return;
        }
        if (c== board.length){
            knights(board, r+1, 0, N);
            return;
        }
        if (isSafe(board, r, c)){
            board[r][c]=true;
            knights(board, r, c+1, N-1);
            board[r][c]=false;
        }
        knights(board, r, c+1, N);

    }
    static void display(boolean[][] board){
        for(boolean[] e: board){
            for(boolean element : e){
                if (element){
                    System.out.print("K ");
                }else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][] board, int r, int c){
        if (isValid(board, r-1, c+2)){
            if (board[r-1][c+2]){
                return false;
            }
        }
        if (isValid(board, r+1, c+2)){
            if (board[r+1][c+2]){
                return false;
            }
        }
        if (isValid(board, r+2, c+1)){
            if (board[r+2][c+1]){
                return false;
            }
        }
        if (isValid(board, r+2, c-1)){
            if (board[r+2][c-1]){
                return false;
            }
        }

        return true;
    }

    static boolean isValid(boolean[][] board, int r, int c){
        if (r>=0 && r< board.length && c>=0 && c< board.length){
            return true;
        }
        return false;
    }
}
