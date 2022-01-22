package com.code.leetcode.editor.cn;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1401 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution34 {
    /**
     * 直接找
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        boolean foundF = false;
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            } else if (nums[i] == target) {
                if (!foundF) {
                    res[0] = i;
                    res[1] = i;
                    foundF = true;
                } else {
                    res[1] = i;
                }
            }
        }

        return res;
    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int m = (h + l) >> 1;
            if (nums[m] == target) {
                res[0] = m;
                res[1] = m;
                int ml = m;
                while (ml >= 0 && nums[ml] == target) {
                    res[0] = ml;
                    ml--;
                }
                int mr = m;
                while (mr < nums.length && nums[mr] == target) {
                    res[1] = mr;
                    mr++;
                }
                break;
            } else if (nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
