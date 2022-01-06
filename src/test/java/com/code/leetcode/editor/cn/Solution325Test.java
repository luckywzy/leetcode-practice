package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/3 11:29 下午
 */
public class Solution325Test {

    @Test
    public void maxSubArrayLen() {
        Solution325 solution325 = new Solution325();
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int k = 3;
        int maxSubArrayLen = solution325.maxSubArrayLen(nums, k);
        Assert.assertEquals(4, maxSubArrayLen);
    }
}