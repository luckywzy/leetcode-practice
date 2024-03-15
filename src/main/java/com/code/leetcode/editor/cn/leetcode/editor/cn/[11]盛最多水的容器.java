package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4681 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution11 {
    public int maxArea1(int[] height) {

        int res = 0;
        // dp[i][j]  表示 i,j 之间时 容器能够容纳水的最大容量
        // dp[i][j] 递推公式：
        //      i < j, max { min{heigh[i], height[j]} * j-i, dp[i-1][j-1],dp[i][j-1],dp[i-1][j]}
        // 初始化：dp[1..i][0] =  Math.min(height[i], height[0]) * (i) ;
        //        dp[0][1..j] = Math.min(height[0], height[j]) * (j);
        // 返回值：dp[height.length-1][height.length-1]
        // 遍历顺序, 0...i, 0..j

        int[][] dp = new int[height.length][height.length];
        for (int i = 1; i < height.length; i++) {
            dp[i][0] = Math.min(height[i], height[0]) * (i);
            res = Math.max(res, dp[i][0]);
        }
        for (int j = 1; j < height.length; j++) {
            dp[0][j] = Math.min(height[0], height[j]) * (j);
            res = Math.max(res, dp[0][j]);
        }

        for (int i = 1; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                dp[i][j] = Math.max(Math.max(area, Math.max(dp[i][j - 1], dp[i - 1][j - 1])), dp[i - 1][j]);
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }


    public int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
            res = Math.max(res, area);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
