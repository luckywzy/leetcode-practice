package com.code.leetcode.editor.cn.leetcode.editor.cn;

import junit.framework.TestCase;
import org.junit.Assert;

public class Solution541Test extends TestCase {

    public void testReverseStr() {
        String reverseStr = new Solution541().reverseStr("abcdefg", 2);
        System.out.println(reverseStr);
        Assert.assertEquals("bacdfeg",reverseStr);
    }
    public void testReverseStr1() {
        String reverseStr = new Solution541().reverseStr("abcd", 2);
        System.out.println(reverseStr);
        Assert.assertEquals("bacd",reverseStr);
    }
}