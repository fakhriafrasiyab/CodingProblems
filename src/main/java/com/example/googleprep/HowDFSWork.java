package com.example.googleprep;

public class HowDFSWork {
    public static void dfs(char[][] islands, int i, int j) {
        int row = islands.length;
        int col = islands[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || islands[i][j] == '0') {
            return;
        }
        islands[i][j] = '0';
        dfs(islands, i + 1, j);
        dfs(islands, i - 1, j);
        dfs(islands, i, j + 1);
        dfs(islands, i, j - 1);
    }

    public static int numsIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numsIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numsIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numsIslands;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numsIslands(grid));
    }
}
