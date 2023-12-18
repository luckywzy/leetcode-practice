package com.code.leetcode.editor.cn.leetcode.editor.cn;

import junit.framework.TestCase;
import org.junit.Assert;

public class Solution3Test extends TestCase {

    public void testLengthOfLongestSubstring() {
        Assert.assertEquals(3, new Solution3().lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(3, new Solution3().lengthOfLongestSubstring("pwwkew"));
    }
}