package com.code;


class Solution248 {
    /**
     * 注；是将数字旋转180度，或者上下颠倒后一样则是中心对称
     * 写一个函数来计算范围在 [low, high] 之间中心对称数的个数。
     * https://leetcode-cn.com/problems/strobogrammatic-number-iii/
     * n 为偶数 时，n的结果是  n-2 的结果中间插入 {"00", "11", "69", "96", "88"} 之后的结果
     * n 为奇数时，n 的结果是 n -1 的结果中间插入 {"0", "1", "8"} 之后的结果
     * 优化思路 缓存中间结果
     * 0,0
     * 1,3
     * 2,4
     * 3,
     */
    public int strobogrammaticInRange(String low, String high) {
        int lo = low.length();
        int hi = high.length();
        for (int n = lo; n <= hi; n++) {
            char[] ans = new char[n];
            findStrobogrammatic(ans, 0, ans.length - 1, low, high);
        }
        return total;
    }

    int total = 0;
    public static final char mapping[][] = new char[][]{
            {'0', '0'},
            {'1', '1'},
            {'6', '9'},
            {'8', '8'},
            {'9', '6'},
    };


    public void findStrobogrammatic(char[] ans, int lo, int hi, String low, String high) {
        if (lo > hi) {
            if (ans.length == 1 || ans[0] != '0') {
                String a = String.valueOf(ans);
                if (compare(a, low) && compare(high, a)) {
                    total++;
                }
            }
            return;
        }
        for (char[] map : mapping) {
            if (lo == hi && map[0] != map[1]) {
                continue;
            }
            ans[lo] = map[0];
            ans[hi] = map[1];
            findStrobogrammatic(ans, lo + 1, hi - 1, low, high);
        }
    }

    private boolean compare(String a, String b) {
        if (a.length() == b.length()) {
            if (a.compareTo(b) >= 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

}