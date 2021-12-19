package com.code.leetcode.editor.cn;

//有一队人（两人或以上）想要在一个地方碰面，他们希望能够最小化他们的总行走距离。 
//
// 给你一个 2D 网格，其中各个格子内的值要么是 0，要么是 1。 
//
// 1 表示某个人的家所处的位置。这里，我们将使用 曼哈顿距离 来计算，其中 distance(p1, p2) = |p2.x - p1.x| + |p2.
//y - p1.y|。 
//
// 示例： 
//
// 输入: 
//
//1 - 0 - 0 - 0 - 1
//|   |   |   |   |
//0 - 0 - 0 - 0 - 0
//|   |   |   |   |
//0 - 0 - 1 - 0 - 0
//
//输出: 6 
//
//解析: 给定的三个人分别住在(0,0)，(0,4) 和 (2,2):
//     (0,2) 是一个最佳的碰面点，其总行走距离为 2 + 2 + 2 = 6，最小，因此返回 6。 
// Related Topics 数组 数学 矩阵 排序 👍 79 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution296 {

    /**
     * 超时了
     * 思路：1、 先找到所有的人； 2、计算每个点与 所有人的距离，记录已计算过的距离中的最小值；返回最小值
     *
     * @param grid
     * @return
     */
    public int minTotalDistance(int[][] grid) {
        List<Pos> manSet = new ArrayList<>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    manSet.add(new Pos(x, y));
                }
            }
        }

        int minSumDis = Integer.MAX_VALUE;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                int sumDistance = 0;
                for (Pos m : manSet) {
                    sumDistance += ditance(m, new Pos(x, y));
                }
                if (sumDistance < minSumDis) {
                    minSumDis = sumDistance;
                }
            }
        }
        return minSumDis;
    }

    /**
     * 实际上曼哈顿距离是在X，Y方向上单独计算的
     * 那我们单独计算每个方向的最小距离
     * 实际上距离每个方向所有点的 最小距离就是，每个方向上的中位数，需要排序
     * 根据中位数，就可以计算每个方向上的最小总距离，即 对每个X都有，abs(x- mid) 再求和，再计算Y方向的即可
     *
     * @param grid
     * @return
     */
    public int minTotalDistance2(int[][] grid) {

        List<Integer> manX = new ArrayList<>();
        List<Integer> manY = new ArrayList<>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    manX.add(x);
                    manY.add(y);
                }
            }
        }
        manX.sort(Comparator.comparingInt(o -> o));
        manY.sort(Comparator.comparingInt(o -> o));

        int midX = manX.get(manX.size() / 2);
        int midY = manY.get(manY.size() / 2);
        int sumDis = 0;
        for (Integer x : manX) {
            sumDis += Math.abs(x - midX);
        }

        for (Integer y : manY) {
            sumDis += Math.abs(y - midY);
        }

        return sumDis;
    }

    private int ditance(Pos a, Pos b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }


    private static class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
