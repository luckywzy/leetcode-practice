package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution122Test {

    @Test
    public void maxProfit() {
        int maxProfit = new Solution122().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertEquals(7, maxProfit);
    }

    @Test
    public void maxProfit1() {
        int maxProfit = new Solution122().maxProfit(new int[]{1,2,3,4,5});
        assertEquals(4, maxProfit);
    }
    @Test
    public void maxProfit2() {
        int maxProfit = new Solution122().maxProfit(new int[]{7,6,4,3,1});
        assertEquals(0, maxProfit);
    }
}