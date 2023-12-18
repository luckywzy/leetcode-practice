package com.code.leetcode.editor.cn.leetcode.editor.cn;

import junit.framework.TestCase;
import org.junit.Assert;

public class Solution344Test extends TestCase {

    public void testReverseString() {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        new Solution344().reverseString(chars);
        System.out.println(chars);
        Assert.assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, chars);
    }

    public void testReverseString1() {
        char[] chars = {'H', 'a', 'n', 'n', 'a', 'h'};
        new Solution344().reverseString(chars);
        System.out.println(chars);
        Assert.assertArrayEquals(new char[]{'h', 'a', 'n', 'n', 'a', 'H'}, chars);
    }

    public void testReverseString2() {
        char[] chars = {'H', 'a'};
        new Solution344().reverseString(chars);
        System.out.println(chars);
        Assert.assertArrayEquals(new char[]{'a', 'H'}, chars);
    }

    public void testReverseString4() {
        char[] chars = {};
        new Solution344().reverseString(chars);
        System.out.println(chars);
        Assert.assertArrayEquals(new char[]{}, chars);
    }


}