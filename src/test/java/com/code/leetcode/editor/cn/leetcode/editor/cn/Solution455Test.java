package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution455Test {

    @Test
    public void findContentChildren() {
        int contentChildren = new Solution455().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        assertEquals(1, contentChildren);
    }

    @Test
    public void findContentChildren1() {
        int contentChildren = new Solution455().findContentChildren(new int[]{1, 2}, new int[]{1, 2,3});
        assertEquals(2, contentChildren);
    }
    @Test
    public void findContentChildren2() {
        int contentChildren = new Solution455().findContentChildren(new int[]{1, 2, 7, 10}, new int[]{1, 3,5, 9});
        assertEquals(3, contentChildren);
    }
}