import java.util.*;
public class TicTacToe {
    public static void main(String[] args){
        char[][] board = new char[3][3];
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col<board[0].length; col++){
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.print("Player " + player + " Turn : ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();
            System.out.println();

            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = hasWon(board, player);
                if(gameOver){
                    System.out.println("Player " + player + " has won the Game. Cheers !!");
                }
                else{
                    if(player == 'X'){
                        player = 'O';
                    }
                    else player = 'X';
                }
            }
            else{
                System.out.println("Invalid Move, Try Again !");
            }
        }
        printBoard(board);
    }
    public static void printBoard(char[][] board){
        for(int row = 0; row<board.length; row++){
            System.out.println("-------------------");
            for(int col = 0; col<board[0].length; col++){
                System.out.print("|  " + board[row][col] + "  ");
            }
            System.out.print("| ");
            System.out.println();

        }
        System.out.println("-------------------");
    }
    public static boolean hasWon(char[][] board, char player){
        //for row
        for(int row = 0; row<board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        //for col
        for(int col = 0; col<board[0].length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col]==player){
                return true;
            }
        }

        //for diagonal right
        if(board[0][0]==player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        //for diagonal left
        if(board[0][2]==player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }
}
