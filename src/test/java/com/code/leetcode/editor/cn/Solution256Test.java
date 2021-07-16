package com.code.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/7/16 11:52 上午
 */
public class Solution256Test {

    @Test
    public void minCost() {
        Solution256 solution256 = new Solution256();

        assertEquals(10, solution256.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));

    }
}