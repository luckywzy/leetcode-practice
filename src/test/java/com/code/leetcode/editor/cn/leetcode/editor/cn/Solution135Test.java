package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution135Test {

    @Test
    public void candy() {
        int candy = new Solution135().candy(new int[]{1, 0, 2});
        assertEquals(5, candy);
    }

    @Test
    public void candy_1() {
        int candy = new Solution135().candy(new int[]{1, 2, 2});
        assertEquals(4, candy);
    }

    @Test
    public void candy_2() {
        int candy = new Solution135().candy(
                new int[]{1, 2, 2, 5, 4, 3, 2});
                        //[1,2, 1, 4, 3, 2, 1]
        assertEquals(14, candy);
    }

    @Test
    public void candy_3() {
        int candy = new Solution135().candy(
                new int[]{1, 2, 1, 3, 4, 3, 2});
                        //[1,2, 1, 2, 3, 2, 1]
        assertEquals(12, candy);
    }

    @Test
    public void candy_4() {
        int candy = new Solution135().candy(
                new int[]{2, 2, 2, 3, 3, 3, 3});
                        //[1,1, 1, 2, 1, 1, 1]
        assertEquals(8, candy);
    }
}