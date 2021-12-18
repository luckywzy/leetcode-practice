package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/18 4:37 下午
 */
public class Solution291Test {

    @Test
    public void wordPatternMatch() {
        Solution291 solution291 = new Solution291();
        Assert.assertTrue(solution291.wordPatternMatch("abab", "redblueredblue"));
    }

    @Test
    public void wordPatternMatch1() {
        Solution291 solution291 = new Solution291();
        Assert.assertTrue(solution291.wordPatternMatch("aaaa", "asdasdasdasd"));
    }

    @Test
    public void wordPatternMatch2() {
        Solution291 solution291 = new Solution291();
        Assert.assertTrue(solution291.wordPatternMatch("abab", "asdasdasdasd"));
        Assert.assertFalse(solution291.wordPatternMatch("aabb", "xyzabcxzyabc"));
    }
    @Test
    public void wordPatternMatch3() {
        Solution291 solution291 = new Solution291();
        Assert.assertFalse(solution291.wordPatternMatch("aabb", "xyzabcxzyabc"));
    }
}