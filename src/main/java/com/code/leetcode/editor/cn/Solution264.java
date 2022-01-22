package com.code.leetcode.editor.cn;

//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 825 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution264 {
    /**
     * 直接递归 计算i是否丑数，是 则数量加1，等到 i == n 时返回i即可
     * 结果：超时
     * 问题在于中间有很多重复计算，需要记录重复计算结果，但是在计算后面的数据帮助不大，还是会超时，需要寻求一种生成丑数的办法
     *
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        int cnt = 0;
        int i = 1;
        Map<Integer, Boolean> exist = new HashMap<>();
        for (; i < Integer.MAX_VALUE; i++) {
            if (isUglyNumber(i, exist)) {
                cnt++;
            }
            if (cnt == n) {
                break;
            }
        }
        return i;
    }

    private boolean isUglyNumber(int i, Map<Integer, Boolean> exist) {
        if (exist.containsKey(i)) {
            return exist.get(i);
        }
        if (i == 1 || i == 2 || i == 3 || i == 5) {
            exist.put(i, true);
            return true;
        }
        boolean u1 = false;
        boolean u2 = (i % 2 != 0) && (i % 3 != 0) && (i % 5 != 0);
        if (u2) {
            exist.put(i, false);
        }
        if (i % 2 == 0) {
            u1 = isUglyNumber(i / 2, exist);
            exist.put(i / 2, u1);
        }
        if (i % 3 == 0) {
            boolean b = isUglyNumber(i / 3, exist);
            exist.put(i / 3, b);
            u1 = b || u1;
        }
        if (i % 5 == 0) {
            boolean b = isUglyNumber(i / 5, exist);
            exist.put(i / 5, b);
            u1 = b || u1;
        }
        return u1;
    }

    /**
     * 丑数可以生成，每次取最小的丑数，乘 2 ，3，5 就是下一个丑数
     *
     * @param n
     * @return
     */
    public int nthUglyNumber3(int n) {
        long cur;
        int ug = 1;
        int[] d = {2, 3, 5};
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o));
        queue.offer(1L);
        set.add(1L);
        for (int i = 0; i < n; i++) {
            cur = queue.poll();
            ug = (int) cur;
            for (int k : d) {
                long next = k * cur;
                if (set.add(next)) {
                    queue.offer(next);
                }
            }

        }
        return ug;
    }


    /**
     * 动态规划：生成丑数； dp[i]标识 第i 个丑数
     * dp[i]  = min(dp[a] * 2,dp[b] * 3, dp[c] * 5);
     * dp[i] == dp[a] || dp[i] == dp[b] || dp[i] == dp[c] , i++;
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            int num1 = dp[a] * 2, num2 = dp[b] * 3, num3 = dp[c] * 5;
            dp[i] = Math.min(num3, Math.min(num1, num2));
            if (dp[i] == num1) {
                a++;
            }
            if (dp[i] == num2) {
                b++;
            }
            if (dp[i] == num3) {
                c++;
            }
        }
        return dp[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
