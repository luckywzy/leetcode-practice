package com.code.leetcode.editor.cn;

//给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。 
//
// 示例: 
//
// 输入: nums = [3,5,2,1,6,4]
//输出: 一个可能的解答是 [3,5,1,6,2,4] 
// Related Topics 贪心 数组 排序 👍 75 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution280 {
    /**
     * 1：先排序，然后从第二个元素开始交换
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length - 1; i = i + 2) {
            swap(nums, i, i + 1);
        }
    }

    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    /**
     * 2：不排序，判断奇偶后, 接着判断大小，直接交换
     * [5,2,1,6,4]
     * [2,5,1,6,4]
     *
     * @param nums
     */
    public void wiggleSort1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    /**
     * 3：条件优化
     * @param nums
     */
    public void wiggleSort2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 && nums[i] > nums[i + 1] || i % 2 == 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }


    /**
     * 4：条件再次优化
     * @param nums
     */
    public void wiggleSort3(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
