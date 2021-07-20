package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/7/19 3:00 下午
 */
public class Solution261Test {

    @Test
    public void validTree() {
        Solution261 solution261 = new Solution261();
        Assert.assertTrue(solution261.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        Assert.assertTrue(solution261.validTree1(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        Assert.assertTrue(solution261.validTree2(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    }

    @Test
    public void validTree1() {
        Solution261 solution261 = new Solution261();
        Assert.assertFalse(solution261.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        Assert.assertFalse(solution261.validTree1(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        Assert.assertFalse(solution261.validTree2(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    }

    @Test
    public void validTree2() {
        Solution261 solution261 = new Solution261();
        Assert.assertFalse(solution261.validTree(4, new int[][]{{0, 1}, {2, 3}}));
        Assert.assertFalse(solution261.validTree1(4, new int[][]{{0, 1}, {2, 3}}));
        Assert.assertFalse(solution261.validTree2(4, new int[][]{{0, 1}, {2, 3}}));
    }

    @Test
    public void validTree3() {
        Solution261 solution261 = new Solution261();
        Assert.assertTrue(solution261.validTree(3, new int[][]{{1, 0}, {2, 0}}));
        Assert.assertTrue(solution261.validTree1(3, new int[][]{{1, 0}, {2, 0}}));
        Assert.assertTrue(solution261.validTree2(3, new int[][]{{1, 0}, {2, 0}}));
    }

    @Test
    public void validTree4() {
        Solution261 solution261 = new Solution261();
        Assert.assertTrue(solution261.validTree(3, new int[][]{{2, 0}, {2, 1}}));
        Assert.assertTrue(solution261.validTree1(3, new int[][]{{2, 0}, {2, 1}}));
        Assert.assertTrue(solution261.validTree2(3, new int[][]{{2, 0}, {2, 1}}));
    }

    @Test
    public void validTree5() {
        Solution261 solution261 = new Solution261();
        Assert.assertFalse(solution261.validTree(5, new int[][]{{0,1},{0,4}, {1,4},{2,3}}));
        Assert.assertFalse(solution261.validTree1(5, new int[][]{{0,1},{0,4}, {1,4},{2,3}}));
        Assert.assertFalse(solution261.validTree2(5, new int[][]{{0,1},{0,4}, {1,4},{2,3}}));
    }

    @Test
    public void validTree6() {
        Solution261 solution261 = new Solution261();
        Assert.assertFalse(solution261.validTree2(4, new int[][]{{0,1},{0,2}, {1,2}}));
    }
}