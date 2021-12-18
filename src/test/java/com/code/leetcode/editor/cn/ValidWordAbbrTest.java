package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/11/18 2:47 下午
 */
public class ValidWordAbbrTest {

    @Test
    public void isUnique() {
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        Assert.assertFalse(validWordAbbr.isUnique("dear"));
        Assert.assertTrue(validWordAbbr.isUnique("cart"));
        Assert.assertFalse(validWordAbbr.isUnique("cane"));
        Assert.assertTrue(validWordAbbr.isUnique("make"));
        Assert.assertTrue(validWordAbbr.isUnique("cake"));
    }


    @Test
    public void isUnique1() {
        /**
         * ["ValidWordAbbr","isUnique","isUnique"]
         * [[["door","naive"]],["cat"],["cat"]]
         * [null,true,true]
         */
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[]{"door", "naive"});
        Assert.assertTrue(validWordAbbr.isUnique("cat"));
        Assert.assertTrue(validWordAbbr.isUnique("cat"));
    }


    @Test
    public void isUnique2() {
        /**
         * [[["deer","door","cake","card"]],["dear"],["door"],["cart"],["cake"]]
         * [null,false,false,true,true]
         */
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[]{"deer","door","cake","card"});
        Assert.assertFalse(validWordAbbr.isUnique("dear"));
        Assert.assertFalse(validWordAbbr.isUnique("door"));
        Assert.assertTrue(validWordAbbr.isUnique("cart"));
        Assert.assertTrue(validWordAbbr.isUnique("cake"));
    }
}