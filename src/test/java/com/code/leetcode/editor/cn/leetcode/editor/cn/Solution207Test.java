package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution207Test {

    @Test
    public void canFinish() {
        assertEquals(true, new Solution207().canFinish(2, new int[][]{{1, 0}}));
        assertEquals(false, new Solution207().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    public void testCanFinish() {
    }
}