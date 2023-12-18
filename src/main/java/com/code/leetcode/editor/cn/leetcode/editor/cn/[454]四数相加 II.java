package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
//
// Related Topics 数组 哈希表 👍 924 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> twoSumMap = new HashMap<>();

        for (int k : nums1) {
            for (int i : nums2) {
                int sum = k + i;
                twoSumMap.put(sum, twoSumMap.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int k : nums3) {
            for (int i : nums4) {
                count += twoSumMap.getOrDefault(-k - i, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int fourSumCount = new Solution454().fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2});
        System.out.println(fourSumCount);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
