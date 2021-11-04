package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/8/11 4:46 下午
 */
public class Solution269Test {

    @Test
    public void alienOrder() {
        Solution269 solution269 = new Solution269();
        Assert.assertEquals("wertf", solution269.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }
}