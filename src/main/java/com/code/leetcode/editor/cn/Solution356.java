package com.code.leetcode.editor.cn;

//在一个二维平面空间中，给你 n 个点的坐标。问，是否能找出一条平行于 y 轴的直线，让这些点关于这条直线成镜像排布？ 
//
// 注意：题目数据中可能有重复的点。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[-1,1]]
//输出：true
//解释：可以找出 x = 0 这条线。
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[-1,-1]]
//输出：false
//解释：无法找出这样一条线。 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 10^4 
// -10^8 <= points[i][j] <= 10^8 
// 
//
// 
//
// 进阶：你能找到比 O(n²) 更优的解法吗? 
// Related Topics 数组 哈希表 数学 👍 27 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution356 {
    /**
     * 找出最大最小的X，取两者和sum，将所有点的x,y存储到set中，
     * 遍历所有points，如果为镜像对称，则对于点A，必定存在点（sum-A.x，A.y）在set中存在，如果不存在则说明不是镜像对称
     * @param points
     * @return
     */
    public boolean isReflected(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int[] point : points) {
            maxX = Math.max(point[0], maxX);
            minX = Math.min(point[0], minX);
            set.add(point[0] + ":" + point[1]);
        }
        int sum = maxX + minX;
        for (int[] point : points) {
            if (!set.contains((sum - point[0]) + ":" + point[1])) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
