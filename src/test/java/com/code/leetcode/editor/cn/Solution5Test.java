package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/9 2:10 下午
 */
public class Solution5Test {

    @Test
    public void longestPalindrome() {
        Solution5 solution5 = new Solution5();
        String babad = solution5.longestPalindrome("babad");
        Assert.assertEquals("bab", babad);
    }
    @Test
    public void longestPalindrome2() {
        Solution5 solution5 = new Solution5();
        String babad = solution5.longestPalindrome("a");
        Assert.assertEquals("a", babad);
    }
}