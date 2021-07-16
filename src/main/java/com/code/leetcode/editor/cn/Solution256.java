package com.code.leetcode.editor.cn;
//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷
//完所有房子最少的花费成本。 
//
// 注意： 
//
// 所有花费均为正整数。 
//
// 示例： 
//
// 输入: [[17,2,17],[16,16,5],[14,3,19]]
//输出: 10
//解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
// 
// Related Topics 数组 动态规划 
// 👍 117 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution256 {
    /**
     *  创建一个minCost 数组 int[][] minCost = new int[length][3];
     *  minCost[i][0] 表示以当前位置为i的房子 图红色时，所花费的最小值
     *  minCost[i][1] 表示以当前位置为i的房子 图蓝色时，所花费的最小值
     *  minCost[i][2] 表示以当前位置为i的房子 图绿色时，所花费的最小值
     *  当执行到位置为N时，在 minCost[i][0], minCost[i][1] minCost[i][2] 中取最小值
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        return doCost(costs);
    }

    public int doCost(int[][] costs) {
        int length = costs.length;
        int[][] minCost = new int[length][3];
        minCost[0][0] += costs[0][0];
        minCost[0][1] += costs[0][1];
        minCost[0][2] += costs[0][2];
        for (int i = 1; i < length; i++) {

            minCost[i][0] = minCost[i - 1][1] < minCost[i - 1][2] ? minCost[i - 1][1] + costs[i][0] :  minCost[i - 1][2] + costs[i][0];
            minCost[i][1] = minCost[i - 1][0] < minCost[i - 1][2] ? minCost[i - 1][0] + costs[i][1] :  minCost[i - 1][2] + costs[i][1];
            minCost[i][2] = minCost[i - 1][0] < minCost[i - 1][1] ? minCost[i - 1][0] + costs[i][2] :  minCost[i - 1][1] + costs[i][2];
        }

        return Math.min(Math.min(minCost[length - 1][0], minCost[length - 1][1]), minCost[length - 1][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
