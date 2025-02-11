package com.example.newChapterInLife;

public class NumberOfIslands {

    public static void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || grid[i][j] == '0' || i >= grid.length || j >= grid[0].length) return;

        grid[i][j] = '0';
        dfs(i - 1, j, grid);//up
        dfs(i + 1, j, grid);//down
        dfs(i, j - 1, grid);//left
        dfs(i, j + 1, grid);//right
    }

    public static int numberOfIslands(char[][] grid) {
        int num=0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if(grid[row][col]=='1'){
                    num++;
                    dfs(row, col, grid);
                }
            }
        }

        return  num;
    }

    public static void main(String[] args) {
//        char[][] grid
    }
}
