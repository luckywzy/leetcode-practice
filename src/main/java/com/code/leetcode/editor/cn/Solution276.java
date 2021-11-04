package com.code.leetcode.editor.cn;

//有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，请你按下述规则为栅栏设计涂色方案： 
//
// 
// 每个栅栏柱可以用其中 一种 颜色进行上色。 
// 相邻的栅栏柱 最多连续两个 颜色相同。 
// 
//
// 给你两个整数 k 和 n ，返回所有有效的涂色 方案数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 2
//输出：6
//解释：所有的可能涂色方案如上图所示。注意，全涂红或者全涂绿的方案属于无效方案，因为相邻的栅栏柱 最多连续两个 颜色相同。
// 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：n = 7, k = 2
//输出：42
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 1 <= k <= 10⁵ 
// 题目数据保证：对于输入的 n 和 k ，其答案在范围 [0, 2³¹ - 1] 内 
// 
// Related Topics 动态规划 👍 135 👎 0


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution276 {
    /**
     * 一般这种都是倒着推倒！！
     * 有N个，已经填了N-1个，最后一个有多少种填法：
     * 1、和第 n-1 个不一样， 那就是有 k-1种
     * 2、和第 n-1 个一样，那 n-1 和 n-2 必定不一样， 那就也是有 k-1 种
     * 所以 1 + 2 的总和就是 结果 ，问题是： num(n-1,k) 和 k-1的关系是什么？
     * 可以看例子：
     * n=1, k=2 两种
     * 1，2
     * n=2, k=2 四种
     * 1,1 2,1
     * 1,2 2,2
     * <p>
     * n=3, k=2 六种
     * 2,1,1
     * 1,2,2
     * <p>
     * 1,1,2
     * 2,2,1
     * 2,1,2
     * 1,2,1
     * <p>
     * 实际上规律不是很明显，注意把K固定住看关系，结论就是 numWays(n-1,k) * (k-1) + numWays(n-2,k)*(k-1)
     *
     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {
        HashMap<Integer, Integer> rememberMap = new HashMap<>();
        return doNumWays(n, k, rememberMap);
    }

    private int doNumWays(int n, int k, HashMap<Integer, Integer> rememberMap) {
        if (rememberMap.containsKey(n)) {
            return rememberMap.get(n);
        }
        if (n == 1) {
            rememberMap.put(n, k);
            return k;
        }
        if (n == 2) {
            rememberMap.put(n, (int) Math.pow(k, n));
            return (int) Math.pow(k, n);
        }

        int ways = doNumWays(n - 1, k, rememberMap) * (k - 1) + doNumWays(n - 2, k, rememberMap) * (k - 1);
        rememberMap.put(n, ways);
        return ways;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
