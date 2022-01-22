package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/16 5:17 下午
 */
public class Solution34Test {

    @Test
    public void searchRange() {
        Solution34 solution34 = new Solution34();
        int[] ints = solution34.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 8);
        Assert.assertEquals(3, ints[0]);
        Assert.assertEquals(4, ints[1]);
    }
}