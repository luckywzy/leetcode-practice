package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/16 9:31 下午
 */
public class Solution394Test {

    @Test
    public void decodeString() {
        Solution394 solution394 = new Solution394();
        String s = solution394.decodeString("3[a]2[bc]");
        Assert.assertEquals("aaabcbc", s);
    }

    @Test
    public void decodeString2() {
        Solution394 solution394 = new Solution394();
        String s = solution394.decodeString("3[a2[c]]");
        Assert.assertEquals("accaccacc", s);
    }

    @Test
    public void decodeString3() {
        Solution394 solution394 = new Solution394();
        String s = solution394.decodeString("abc3[cd]xyz");
        Assert.assertEquals("abccdcdcdxyz", s);
    }
}