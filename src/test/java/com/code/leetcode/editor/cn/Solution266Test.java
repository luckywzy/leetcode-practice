package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/7/21 3:09 下午
 */
public class Solution266Test {

    @Test
    public void canPermutePalindrome1() {
        Solution266 solution266 = new Solution266();
        assertTrue(solution266.canPermutePalindrome("carerac"));
        assertTrue(solution266.canPermutePalindrome("aab"));
        assertFalse(solution266.canPermutePalindrome("code"));
        assertFalse(solution266.canPermutePalindrome("co"));
        assertTrue(solution266.canPermutePalindrome("c"));
    }

    @Test
    public void canPermutePalindrome2() {
        Solution266 solution266 = new Solution266();
        assertTrue(solution266.canPermutePalindrome1("carerac"));
        assertTrue(solution266.canPermutePalindrome1("aab"));
        assertFalse(solution266.canPermutePalindrome1("code"));
        assertFalse(solution266.canPermutePalindrome1("co"));
        assertTrue(solution266.canPermutePalindrome1("c"));
    }
}