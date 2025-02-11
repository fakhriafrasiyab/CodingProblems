package com.example.newChapterInLife;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int bfs(int[][] grid, int freshCount, Queue<int[]> queue) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            while (size-- > 0) {
                int[] current = queue.poll();

                int x = current[0];
                int y = current[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0], newY = y + dir[1];

                    if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        rotted = true;
                        freshCount--;

                    }
                }
            }
            if (rotted) minutes++;
        }


        return (freshCount == 0) ? minutes : -1;
    }


    public static int rottingOranges(int[][] grid) {
        int freshCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) return 0;

        return bfs(grid, freshCount, queue);
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};

        System.out.println(rottingOranges(grid));
    }
}
