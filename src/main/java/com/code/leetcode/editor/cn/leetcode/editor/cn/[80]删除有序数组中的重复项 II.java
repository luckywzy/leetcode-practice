package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明： 
//
// 为什么返回数值是整数，但输出的答案是数组呢？ 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,2,2,3]
//输出：5, nums = [1,1,2,2,3]
//解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,1,2,3,3]
//输出：7, nums = [0,0,1,1,2,3,3]
//解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素
//。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按升序排列 
// 
//
// Related Topics 数组 双指针 👍 1002 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution80 {
    public int removeDuplicates(int[] nums) {
        //暴力解法,用一个 map 将 num[i] 以及出现的次数存起来然后再重新构建这个数组
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int preNum = 0;
        int i = 0;
        int index = 0;
        while (i < nums.length && index < nums.length) {
            nums[i++] = nums[index];
            if (map.get(nums[index]) >= 2) {
                nums[i++] = nums[index];
            }

            index = map.get(nums[index]) + index;
        }
        return i;
    }

    public int removeDuplicates1(int[] nums) {
        //map 将 num[i] 以及出现的次数存起来不是必须的，因为每次只用到下一个数字的数量
        int cur = 0;
        int index = 0;
        int nextNumIndex = 0;
        /**
         * 1,1,1,2,2,3
         *
         */
        while (index < nums.length) {
            while (nextNumIndex < nums.length && nums[nextNumIndex] == nums[index]) {
                nextNumIndex++;
            }
            nums[cur++] = nums[index];
            if (nextNumIndex - index >= 2) {
                nums[cur++] = nums[index];
            }

            index = nextNumIndex;
        }
        return cur;
    }

    public int removeDuplicates2(int[] nums) {
        //map 将 num[i] 以及出现的次数存起来不是必须的，因为每次只用到下一个数字的数量
        if (nums.length <= 2) {
            return nums.length;
        }
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
