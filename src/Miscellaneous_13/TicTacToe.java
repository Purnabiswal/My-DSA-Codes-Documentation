package src.Miscellaneous_13;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        char[][] board=new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]=' ';
            }
        }
        game(board);
    }

    static void game(char[][] board){
        Random random=new Random();
        char player;
        boolean x=random.nextBoolean();
        if (x){
            player='X';
        }else {
            player='O';
        }
        boolean gameOver=false;
        int count=0;
        while (count!=9){
            printBoard(board);
            System.out.println("Player "+player+ " enter: ");
            gameOver=enter(board, player);
            if (gameOver){
                printBoard(board);
                System.out.println("Player "+player+" won!!");
                break;
            }
            player=(player=='X')?'O':'X';
            count++;
        }
        if (!gameOver){
            Scanner sc = new Scanner(System.in);
            printBoard(board);
            System.out.println("Oh oh Game Over, No winners!!!");
            System.out.println("Thanks for playing!!!");
            System.out.println("Enter 1 to restart & 0 to stop.");
            String s;
            s=sc.next();
            if (Objects.equals(s, "1")){
                //reset
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        board[i][j]=' ';
                    }
                }
                game(board);
            }
        }
    }
    static boolean check(char[][] board, int r, int c){
        int x=board[r][c];
        boolean isOver=false;
        int i;
        int j;

        //for row
        for ( i = 0; i < 3; i++) {
            if(board[r][i]!=x){
                break;
            }
        }
        if (i==3){
            return true;
        }
        //for col
        for ( i = 0; i < 3; i++) {
            if(board[i][c]!=x){
                break;
            }
        }
        if (i==3){
            return true;
        }
        //for diagonal
        if ( (r!=1 && c!=1) || (r==1 && c==1)){
            for ( i = 0, j=0; i < 3 && j<3; i++, j++) {
                if(board[i][j]!=x){
                    break;
                }
            }
            if (i==3){
                return true;
            }
            for ( i = 0, j=0; i < 3 && j<3; i++, j++) {
                if(board[i][j]!=x){
                    break;
                }
            }
            return i == 3;
        }
        return false;
    }
    static boolean enter(char[][] board, char player){
        Scanner sc = new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        if (row > 2 || col > 2){
            System.out.println("Please enter valid input. ");
            enter(board, player);
            return false;
        }
        boolean isValid=board[row][col] == ' ';
        if (!isValid){
            System.out.println("Already filled, try again!");
            enter(board, player);
            return false;
        }
        board[row][col]=player;
        return check(board, row, col);
    }

    static public void printBoard(char[][] board){
        System.out.println("   0   1   2");
        System.out.println(" ┌───┬───┬───┐");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + "│");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " │");
            }
            System.out.println();
            if (i < board.length - 1)
                System.out.println(" ├───┼───┼───┤");
        }
        System.out.println(" └───┴───┴───┘");
    }

}
