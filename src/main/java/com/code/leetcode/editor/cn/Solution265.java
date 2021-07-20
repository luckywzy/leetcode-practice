package com.code.leetcode.editor.cn;

//假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此
//类推。请你计算出粉刷完所有房子最少的花费成本。 
//
// 注意： 
//
// 所有花费均为正整数。 
//
// 示例： 
//
// 输入: [[1,5,3],[2,9,4]]
//输出: 5
//解释: 将 0 号房子粉刷成 0 号颜色，1 号房子粉刷成 2 号颜色。最少花费: 1 + 4 = 5; 
//     或者将 0 号房子粉刷成 2 号颜色，1 号房子粉刷成 0 号颜色。最少花费: 3 + 2 = 5. 
// 
//
// 进阶： 
//您能否在 O(nk) 的时间复杂度下解决此问题？ 
// Related Topics 数组 动态规划 
// 👍 83 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution265 {

    /**
     * 贪心计算，untilCurHouseMinCost[i][j] 表示第i栋房子在颜色j下的 粉刷房子成本的最小值；
     * 计算完成后，遍历一遍最后一行，取最小值即是结果
     * @param costs
     * @return
     */
    public int minCostII(int[][] costs) {

        int maxK = 0;
        for (int i = 0; i < costs.length; i++) {
            maxK = Math.max(maxK, costs[i].length);
        }

        int[][] untilCurHouseMinCost = new int[costs.length][maxK];
        //init
        for (int i = 0; i < costs[0].length; i++) {
            untilCurHouseMinCost[0][i] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            //循环每个房子的颜色
            for (int j = 0; j < costs[i].length; j++) {
                //记录当前按照不同颜色粉刷房子成本的最小值
                for (int k = 0; k < untilCurHouseMinCost[i].length; k++) {
                    int preMinCost = untilCurHouseMinCost[i - 1][k];
                    //不同颜色才处理
                    if (j != k) {
                        if (untilCurHouseMinCost[i][j] == 0) {
                            untilCurHouseMinCost[i][j] += preMinCost + costs[i][j];
                        } else {
                            untilCurHouseMinCost[i][j] = Math.min(untilCurHouseMinCost[i][j], preMinCost + costs[i][j]);
                        }
                    }
                }
            }
        }
        return Arrays.stream(untilCurHouseMinCost[costs.length - 1]).min().getAsInt();

    }


    /**
     * 优化空间占用，滚动数组
     * @param costs
     * @return
     */
    public int minCostII2(int[][] costs) {
        int[][] untilCurHouseMinCost = new int[costs[0].length][2];
        //init
        for (int i = 0; i < costs[0].length; i++) {
            untilCurHouseMinCost[i][0] = costs[0][i];
           // untilCurHouseMinCost[i][1] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            //循环每个房子的颜色
            for (int j = 0; j < costs[i].length; j++) {
                //记录当前按照不同颜色粉刷房子成本的最小值
                int curMin = Integer.MAX_VALUE;
                for (int k = 0; k < untilCurHouseMinCost.length; k++) {
                    if (j == k) {
                        continue;
                    }
                    //不同颜色才处理
                    curMin = Math.min(curMin, untilCurHouseMinCost[k][0] + costs[i][j]);
                }
                untilCurHouseMinCost[j][1] = curMin;
            }
            for (int[] u : untilCurHouseMinCost) {
                u[0] = u[1];
            }
        }

        int curMin = Integer.MAX_VALUE;
        for (int[] uc : untilCurHouseMinCost) {
            curMin = Math.min(curMin, uc[0]);
        }

        return curMin;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
