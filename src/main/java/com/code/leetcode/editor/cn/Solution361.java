package com.code.leetcode.editor.cn;

//给你一个大小为 m x n 的矩阵 grid ，其中每个单元格都放置有一个字符： 
//
// 
// 'W' 表示一堵墙 
// 'E' 表示一个敌人 
// '0'（数字 0）表示一个空位 
// 
//
// 返回你使用 一颗炸弹 可以击杀的最大敌人数目。你只能把炸弹放在一个空位里。 
//
// 由于炸弹的威力不足以穿透墙体，炸弹只能击杀同一行和同一列没被墙体挡住的敌人。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [["0","E","0","0"],
//             ["E","0","W","E"],
//             ["0","E","0","0"]]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：grid = [["W","W","W"],
//             ["0","0","0"],
//             ["E","E","E"]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 可以是 'W'、'E' 或 '0' 
// 
// Related Topics 数组 动态规划 矩阵 👍 74 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution361 {
    /**
     * 暴力计算
     *
     * @param grid
     * @return
     */
    public int maxKilledEnemies(char[][] grid) {

        int[][] boomCount = new int[grid.length][grid[0].length];
        int maxBoomCnt = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char c = grid[i][j];
                if (c == 'W') {
                    //墙
                    boomCount[i][j] = 0;
                }
                if (c == 'E') {
                    //敌人
                    boomCount[i][j] = 0;
                }
                if (c == '0') {
                    //空
                    int l = i;
                    while (l >= 0 && grid[l][j] != 'W') {
                        if (grid[l][j] == 'E') {
                            boomCount[i][j]++;
                        }
                        l--;
                    }
                    int r = i;
                    while (r < grid.length && grid[r][j] != 'W') {
                        if (grid[r][j] == 'E') {
                            boomCount[i][j]++;
                        }
                        r++;
                    }
                    int u = j;
                    while (u >= 0 && grid[i][u] != 'W') {
                        if (grid[i][u] == 'E') {
                            boomCount[i][j]++;
                        }
                        u--;
                    }
                    int d = j;
                    while (d < grid[0].length && grid[i][d] != 'W') {
                        if (grid[i][d] == 'E') {
                            boomCount[i][j]++;
                        }
                        d++;
                    }
                }
                maxBoomCnt = Math.max(boomCount[i][j], maxBoomCnt);
            }
        }

        return maxBoomCnt;
    }

    public int maxKilledEnemies2(char[][] grid) {

        int[][] enemies = new int[grid.length][grid[0].length];
        int[][] boomCount = new int[grid.length][grid[0].length];
        int maxBoomCnt = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            char c = grid[0][i];
            if(c == 'W'){
                enemies[0][i] = 0;
            }
            if(c == 'E'){
                enemies[0][i] = enemies[0][i-1] + 1;
            }
            if(c == '0'){
                enemies[0][i] = enemies[0][i-1];
                boomCount[0][i] = 1;
            }
        }




        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

            }
        }

        return maxBoomCnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
