package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2391 👎 0


import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    //bfs
    public int numIslands1(char[][] grid) {
        int count = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        int r = point[0], c = point[1];
                        grid[r][c] = '0';
                        if (isValid(grid, r + 1, c)) {
                            queue.offer(new int[]{r + 1, c});
                            grid[r + 1][c] = '0';
                        }
                        if (isValid(grid, r - 1, c)) {
                            queue.offer(new int[]{r - 1, c});
                            grid[r - 1][c] = '0';
                        }
                        if (isValid(grid, r, c + 1)) {
                            queue.offer(new int[]{r, c + 1});
                            grid[r][c + 1] = '0';
                        }
                        if (isValid(grid, r, c - 1)) {
                            queue.offer(new int[]{r, c - 1});
                            grid[r][c - 1] = '0';
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    boolean isValid(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return false;
        }
        return true;
    }


    void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
