package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/12 11:43 下午
 */
public class Solution33Test {

    @Test
    public void search() {
        Solution33 solution33 = new Solution33();
        int search = solution33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        Assert.assertEquals(-1, search);
    }

    @Test
    public void search2() {
        Solution33 solution33 = new Solution33();
        int search = solution33.search(new int[]{1}, 1);
        Assert.assertEquals(0, search);
    }

    @Test
    public void search3() {
        Solution33 solution33 = new Solution33();
        int search = solution33.search(new int[]{1, 3}, 3);
        Assert.assertEquals(1, search);
    }

    @Test
    public void search5() {
        Solution33 solution33 = new Solution33();
        int search = solution33.search(new int[]{1, 3}, 1);
        Assert.assertEquals(0, search);
    }

    @Test
    public void search4() {
        Solution33 solution33 = new Solution33();
        int search = solution33.search(new int[]{1}, 1);
        Assert.assertEquals(0, search);
    }
}