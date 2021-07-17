package com.code.leetcode.editor.cn;

//给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三
//元组 i, j, k 个数（0 <= i < j < k < n）。 
//
// 示例： 
//
// 输入: nums = [-2,0,1,3], target = 2
//输出: 2 
//解释: 因为一共有两个三元组满足累加和小于 2:
//     [-2,0,1]
//     [-2,0,3]
// 
//
// 进阶：是否能在 O(n2) 的时间复杂度内解决？ 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 80 👎 0


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution259 {

    /**
     * 1. 先排序，然后固定一个数 a，剩下的两个数按照双指针法l,r，
     * 如果剩下的两个数的和 < target - a，那么在r-l 的所有组合都满足，因为数组已经排序；
     * 否则 r --;
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        int total = 0;
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        list.sort(Comparator.comparingInt(o -> o));

        int l, r;
        for (int i = 0; i < list.size(); i++) {
            l = i + 1;
            int last = target - list.get(i);
            r = nums.length - 1;
            while (l < r) {
                int twoSum = list.get(l) + list.get(r);
                if (twoSum >= last) {
                    r--;
                } else {
                    total += r - l;
                    l++;
                }
            }
        }
        return total;
    }

    public int twoSumSmaller1(int[] nums, int i, int j, int target) {
        int total = 0;

        int l = 1, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                total++;

            }
        }

        return total;
    }


    /**
     * 方法1：暴力搜索，直接三层循环，超时
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller1(int[] nums, int target) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += twoSumSmaller(nums, i + 1, nums.length, target - nums[i]);
        }
        return total;
    }

    public int twoSumSmaller(int[] nums, int i, int j, int target) {
        int total = 0;
        for (int a = i; a < j; a++) {
            total += oneSmaller(nums, a + 1, j, target - nums[a]);
        }
        return total;
    }

    public int oneSmaller(int[] nums, int i, int j, int target) {
        int total = 0;
        for (int a = i; a < j; a++) {
            if (nums[a] < target) {
                total++;
            }
        }
        return total;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
