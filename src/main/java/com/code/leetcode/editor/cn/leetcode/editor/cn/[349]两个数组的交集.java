package com.code.leetcode.editor.cn.leetcode.editor.cn;//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 856 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int j : nums1) {
            set.add(j);
        }
        Set<Integer> res = new HashSet<Integer>();
        for (int j : nums2) {
            if (set.contains(j)) {
                res.add(j);
            }
        }
        int[] resArr = new int[res.size()];
        return  res.stream().mapToInt(e->e).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution349().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new Solution349().intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
