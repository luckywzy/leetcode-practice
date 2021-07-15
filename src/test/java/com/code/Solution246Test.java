package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/23 8:00 下午
 */
public class Solution246Test {

    @Test
    public void isStrobogrammatic() {

        Assert.assertFalse(new Solution246().isStrobogrammatic("99"));
        Assert.assertTrue(new Solution246().isStrobogrammatic("69"));
        Assert.assertTrue(new Solution246().isStrobogrammatic("96"));
        Assert.assertTrue(new Solution246().isStrobogrammatic("8"));
        Assert.assertFalse(new Solution246().isStrobogrammatic("2"));
        Assert.assertFalse(new Solution246().isStrobogrammatic("5"));
        Assert.assertFalse(new Solution246().isStrobogrammatic("692"));
        Assert.assertFalse(new Solution246().isStrobogrammatic("696"));
        Assert.assertTrue(new Solution246().isStrobogrammatic("1"));
        Assert.assertTrue(new Solution246().isStrobogrammatic("1111"));
        Assert.assertTrue(new Solution246().isStrobogrammatic("116989686911"));
    }
}