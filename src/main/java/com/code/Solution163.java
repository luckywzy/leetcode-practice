package com.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/21 4:36 下午
 */
public class Solution163 {

    /**
     * https://leetcode-cn.com/problems/missing-ranges/
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> ans = new ArrayList<>();
        long l = lower;
        long u = upper;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - l == 1) {
                ans.add(String.valueOf(l));
            } else if (nums[i] - l > 1) {
                ans.add(l + "->" + (nums[i] - 1));
            }

            l = (long) nums[i] + 1;

        }
        if (l == u) {
            ans.add(String.valueOf(l));
        } else if (l < u) {
            ans.add(l + "->" + u);
        }
        return ans;
    }

}
