package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/19 3:25 下午
 */
public class Solution302Test {

    @Test
    public void minArea() {
        Solution302 solution302 = new Solution302();
        int area = solution302.minArea(new char[][]{
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '1', '0', '0'},

        }, 0, 2);

        Assert.assertEquals(6, area);
    }

    @Test
    public void minArea2() {
        Solution302 solution302 = new Solution302();
        int area = solution302.minArea(new char[][]{
                {'1'},

        }, 0, 0);

        Assert.assertEquals(1, area);
    }
}