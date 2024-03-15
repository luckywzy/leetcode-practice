package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1747 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution75 {
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    redCount++;
                    break;
                case 1:
                    whiteCount++;
                    break;
                case 2:
                    blueCount++;
                    break;
            }
        }
        Arrays.fill(nums, 0, redCount, 0);
        Arrays.fill(nums, redCount, redCount + whiteCount, 1);
        Arrays.fill(nums, redCount + whiteCount, nums.length, 2);
    }

    /**
     * 1, 2, 0, 0, 1, 2}
     *
     * @param nums
     */
    public void sortColors1(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int a = nums[i];
                nums[i] = nums[p1];
                nums[p1] = a;
                p1++;
            } else if (nums[i] == 0) {
                int a = nums[i];
                nums[i] = nums[p0];
                nums[p0] = a;
                if (p0 < p1) {
                    int tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                p1++;
                p0++;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
