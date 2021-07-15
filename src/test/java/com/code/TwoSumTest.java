package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/22 12:09 下午
 */
public class TwoSumTest {

    @Test
    public void find() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(5);
        twoSum.add(3);
        Assert.assertTrue(twoSum.find1(8));
        Assert.assertFalse(twoSum.find1(7));
    }

    @Test
    public void find2() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(5);
        twoSum.add(3);
        twoSum.add(10);
        Assert.assertTrue(twoSum.find1(15));
        Assert.assertFalse(twoSum.find1(9));
    }

    @Test
    public void find3() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(1);
        Assert.assertFalse(twoSum.find1(2));
        Assert.assertTrue(twoSum.find1(3));
        Assert.assertTrue(twoSum.find1(4));
        Assert.assertTrue(twoSum.find1(5));
        Assert.assertFalse(twoSum.find1(6));
    }

    @Test
    public void find4() {
        TwoSum.TwoSum2 twoSum = new TwoSum.TwoSum2();
        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(1);
        Assert.assertFalse(twoSum.find(2));
        Assert.assertTrue(twoSum.find(3));
        Assert.assertTrue(twoSum.find(4));
        Assert.assertTrue(twoSum.find(5));
        Assert.assertFalse(twoSum.find(6));
    }
}