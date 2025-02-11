//package com.example.tictactoe;
//
//import java.util.Scanner;
//
///*
// * TicTacToe (a.k.a. Noughts and Crosses)
// * Is played by two players on a 3x3 board of cells
// *
// * RULES:
// * - Players alternate placing X's and O's on the board
// * - Players cannot play on a played position
// * - A player with three X's or O's in a row (horizontally, vertically or diagonally) wins
// * - If all nine squares are filled and neither player achieves three in a row, the game is a draw
// */
//public class TicTacToe {
//
//    public static void main(String[] args) {
//        char[][] board = new char[3][3];
//        startBoard(board);
//
//        boolean playerX=true;
//        int moves=0;
//        while(true){
//            char currentPlayer = playerX ? 'X' : 'O';
//            int [] position = movePlayer();
//            int row = movePlayer()[0];
//            int column = movePlayer()[1];
//            if(isValidMove){
//                board[row][column]=currentPlayer;
//                moves++;
//                if(checkWin(board, currentPlayer)){
//                    printBoard;
//                    break;
//                }else if(moves==9){
//                    printBoard;// draw
//                }
//            }
//        }
//    }
//
//    public static void startBoard(char[][] board) {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                board[i][j]=' ';
//            }
//        }
//    }
//
////    public boolean isValidMove(char[][] board, int row, int col){
////        if(row>0)
////        return false;
////    }
//
//    public static int[] movePlayer(){
////        Scanner scanner = new Scanner(System.in);
//        int row = 3;
//        int col = 2;
//        return new int[]{row, col};
//    }
//
////    void printBoard
//
//    public static boolean checkWin(char [][] board, char currentPlayer){
//        for (int i=0; i<3;i++){
//            //horizontal win
//            if(board[i][0]==currentPlayer && board[i][1]==currentPlayer && board[i][2]==currentPlayer ){
//                return true;
//            }
//            //vertical win
//            if (board[0][i]==currentPlayer  && board[1][i]==currentPlayer && board[2][i]==currentPlayer ){
//                return true;
//            }
//        }
//        if (board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2]==currentPlayer ){
//            return true;
//        }
//        if (board[0][2]==currentPlayer && board[1][1]==currentPlayer && board[2][0]==currentPlayer){
//            return true;
//        }
//
//        return false;
//    }
//
//}


