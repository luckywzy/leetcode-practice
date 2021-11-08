package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/11/8 3:25 下午
 */
public class Solution277Test {

    @Test
    public void findCelebrity() {
        Solution277 solution277 = new Solution277(new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {1, 1, 1}
        });
        int celebrity = solution277.findCelebrity(3);
        Assert.assertEquals(1, celebrity);
    }

    @Test
    public void findCelebrity1() {
        Solution277 solution277 = new Solution277(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1}
        });
        int celebrity = solution277.findCelebrity(3);
        Assert.assertEquals(-1, celebrity);
    }


    @Test
    public void findCelebrity1_0() {
        Solution277 solution277 = new Solution277(new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {1, 1, 1}
        });
        int celebrity = solution277.findCelebrity1(3);
        Assert.assertEquals(1, celebrity);
    }

    @Test
    public void findCelebrity1_1() {
        Solution277 solution277 = new Solution277(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1}
        });
        int celebrity = solution277.findCelebrity1(3);
        Assert.assertEquals(-1, celebrity);
    }

    @Test
    public void findCelebrity1_2() {
        Solution277 solution277 = new Solution277(new int[][]{
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 1}
        });
        int celebrity = solution277.findCelebrity1(4);
        Assert.assertEquals(1, celebrity);
    }

    @Test
    public void findCelebrity1_3() {
        Solution277 solution277 = new Solution277(new int[][]{
                {1, 0},
                {0, 1}
        });
        int celebrity = solution277.findCelebrity1(2);
        Assert.assertEquals(-1, celebrity);
    }
}