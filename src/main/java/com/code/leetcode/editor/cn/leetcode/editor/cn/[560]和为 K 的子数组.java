package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2273 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution560 {

    //暴力两层循环
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    //利用前缀和
    public int subarraySum1(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);//前缀和-k 等于 0，也需要加 1
        for (int i = 0; i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                ans++;
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
