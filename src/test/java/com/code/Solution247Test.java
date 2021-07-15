package com.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/24 8:12 下午
 */
public class Solution247Test {

    @Test
    public void findStrobogrammatic() {
        List<String> ans = new Solution247().findStrobogrammatic(2);
        List<String> exp = new ArrayList<>();
        exp.add("11");
        exp.add("69");
        exp.add("88");
        exp.add("96");
        Assert.assertEquals(exp, ans);
    }

    @Test
    public void findStrobogrammatic12() {
        //5s
        List<String> ans = new Solution247().findStrobogrammatic(12);

        System.out.println(ans);
    }
}