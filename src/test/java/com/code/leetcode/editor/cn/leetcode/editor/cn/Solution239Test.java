package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution239Test {

    @Test
    public void maxSlidingWindow() {
        //3,3,5,5,6,7
        int[] maxSlidingWindow = new Solution239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i = 0; i < maxSlidingWindow.length; i++) {
            System.out.print(maxSlidingWindow[i] + ",");
        }
    }
}