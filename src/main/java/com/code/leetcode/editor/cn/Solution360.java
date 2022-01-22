package com.code.leetcode.editor.cn;

//给你一个已经 排好序 的整数数组 nums 和整数 a、b、c。对于数组中的每一个数 x，计算函数值 f(x) = ax² + bx + c，请将函数值产生
//的数组返回。 
//
// 要注意，返回的这个数组必须按照 升序排列，并且我们所期望的解法时间复杂度为 O(n)。 
//
// 示例 1： 
//
// 输入: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
//输出: [3,9,15,33]
// 
//
// 示例 2： 
//
// 输入: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
//输出: [-23,-5,1,7]
// 
// Related Topics 数组 数学 双指针 排序 👍 53 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        TreeMap<Integer, Integer> treeSet = new TreeMap<>(Comparator.comparingInt(o -> o));

        for (int num : nums) {
            treeSet.compute(fx(num, a, b, c), (k, oldVal) -> oldVal == null ? 1 : oldVal + 1);
        }
        int[] res = new int[nums.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : treeSet.entrySet()) {
            for (int k = 0; k < entry.getValue(); k++) {
                res[i++] = entry.getKey();
            }
        }

        return res;
    }


    int fx(int x, int a, int b, int c) {
        return a * (int) Math.pow(x, 2) + b * x + c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
