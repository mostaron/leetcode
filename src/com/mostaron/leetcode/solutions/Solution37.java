package com.mostaron.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;


public class Solution37 {

    class Position {
        int x;
        int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void solveSudoku(char[][] board) {

        List<Position> positionList = new ArrayList<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    Position position = new Position(i, j);
                    positionList.add(position);
                }
            }
        }

        for(int i=0; i<positionList.size(); ){
            Position position = positionList.get(i);
            boolean suitable = generate(board, position);
            if(!suitable){
                if(i==0){
                    System.out.println("本数独无解");
                    break;
                }
                board[position.x][position.y] = '.';
                i--;
            }else{
                i++;
            }
        }
    }

    private boolean generate(char[][] board, Position position){
        boolean suitable = true;
        char startValue = (board[position.x][position.y]=='.') ? '1' : board[position.x][position.y];
        for(char i = startValue; i <= '9'; i++){
            suitable = true;
            for(int n = 0; n < 9; n++){
                if(board[n][position.y] == i ) {
                    suitable = false;
                    break;
                }
                if(board[position.x][n] == i ) {
                    suitable = false;
                    break;
                }
            }
            if(!suitable) {
                continue;
            }

            int x1 = position.x / 3 * 3;
            int y1 = position.y / 3 * 3;
            for(int xn = 0; xn <3; xn++){
                for(int yn = 0; yn <3; yn++){
                    if(board[x1+xn][y1+yn] == i){
                        suitable = false;
                        break;
                    }
                }
            }
            if(!suitable) {
                continue;
            }else{
                board[position.x][position.y] = i;
                break;
            }

        }
        return suitable;

    }

    public static void main(String...args){
        char[][] c = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new Solution37().solveSudoku(c);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
    }

}
