package com.code.leetcode.editor.cn.leetcode.editor.cn;

import junit.framework.TestCase;
import org.junit.Assert;

public class Solution42Test extends TestCase {

    public void testTrap() {
        Assert.assertEquals(6, new Solution42().trap(new  int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        Assert.assertEquals(9, new Solution42().trap(new  int[]{4,2,0,3,2,5}));
    }

    public void testTrap1() {
        Assert.assertEquals(6, new Solution42().trap1(new  int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        Assert.assertEquals(9, new Solution42().trap1(new  int[]{4,2,0,3,2,5}));
    }
}