package com.code.leetcode.editor.cn;

//图片在计算机处理中往往是使用二维矩阵来表示的。 
//
// 给你一个大小为 m x n 的二进制矩阵 image 表示一张黑白图片，0 代表白色像素，1 代表黑色像素。 
//
// 黑色像素相互连接，也就是说，图片中只会有一片连在一块儿的黑色像素。像素点是水平或竖直方向连接的。 
//
// 给你两个整数 x 和 y 表示某一个黑色像素的位置，请你找出包含全部黑色像素的最小矩形（与坐标轴对齐），并返回该矩形的面积。 
//
// 你必须设计并实现一个时间复杂度低于 O(mn) 的算法来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：image = [["0","0","1","0"],["0","1","1","0"],["0","1","0","0"]], x = 0, y =
// 2
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：image = [["1"]], x = 0, y = 0
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == image.length 
// n == image[i].length 
// 1 <= m, n <= 100 
// image[i][j] 为 '0' 或 '1' 
// 1 <= x < m 
// 1 <= y < n 
// image[x][y] == '1' 
// image 中的黑色像素仅形成一个 组件 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 二分查找 矩阵 👍 39 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution302 {

    int[] maxP = new int[2];
    int[] mimP = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

    int[][] round = new int[][]{
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
    };

    public int minArea(char[][] image, int x, int y) {
        int[][] visited = new int[image.length][image[0].length];

        dfs(image, x, y, visited);
        return (maxP[0] - mimP[0] + 1) * (maxP[1] - mimP[1] + 1);
    }

    private void dfs(char[][] image, int x, int y, int[][] visited) {
        if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == '1') {
            if (visited[x][y] == 1) {
                return;
            }
            visited[x][y] = 1;

            if (maxP[0] <= x) {
                maxP[0] = x;
            }
            if (mimP[0] >= x) {
                mimP[0] = x;
            }
            if (maxP[1] <= y) {
                maxP[1] = y;
            }
            if (mimP[1] >= y) {
                mimP[1] = y;
            }
            //上下左右
            for (int[] rs : round) {
                dfs(image, x + rs[0], y + rs[1], visited);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
