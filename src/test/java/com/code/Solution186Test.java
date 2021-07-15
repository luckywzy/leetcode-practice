package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/22 2:14 下午
 */
public class Solution186Test {

    @Test
    public void reverseWords() {
        char[] chars = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        new Solution186().reverseWords(chars);
        Assert.assertArrayEquals(new char[]{'b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'}, chars);
    }

    @Test
    public void reverseWords1() {
        char[] chars = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        new Solution186().reverseWords1(chars);
        Assert.assertArrayEquals(new char[]{'b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'}, chars);
    }
}