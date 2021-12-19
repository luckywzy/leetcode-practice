package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/18 6:11 下午
 */
public class Solution293Test {

    @Test
    public void generatePossibleNextMoves() {
        Solution293 solution293 = new Solution293();
        List<String> act = solution293.generatePossibleNextMoves("++++");


        Set<String> exp = new HashSet<>();
        exp.add("--++");
        exp.add("+--+");
        exp.add("++--");

        Assert.assertEquals(exp.size(), act.size());

        exp.forEach(e -> {
            Assert.assertTrue(act.contains(e));
        });
    }

    @Test
    public void generatePossibleNextMoves1() {
        Solution293 solution293 = new Solution293();
        List<String> act = solution293.generatePossibleNextMoves_opti1("++++");


        Set<String> exp = new HashSet<>();
        exp.add("--++");
        exp.add("+--+");
        exp.add("++--");

        Assert.assertEquals(exp.size(), act.size());

        exp.forEach(e -> {
            Assert.assertTrue(act.contains(e));
        });
    }

    @Test
    public void generatePossibleNextMoves2() {
        Solution293 solution293 = new Solution293();
        List<String> act = solution293.generatePossibleNextMoves_opti2("++++");


        Set<String> exp = new HashSet<>();
        exp.add("--++");
        exp.add("+--+");
        exp.add("++--");

        Assert.assertEquals(exp.size(), act.size());

        exp.forEach(e -> {
            Assert.assertTrue(act.contains(e));
        });
    }
}