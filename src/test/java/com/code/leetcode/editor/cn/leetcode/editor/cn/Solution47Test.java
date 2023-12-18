package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution47Test {

    @Test
    public void permuteUnique() {
        List<List<Integer>> subsets = new Solution47().permuteUnique(new int[]{1,2,3});
        subsets.forEach(p -> {
            System.out.print("[");
            p.forEach(s -> System.out.print(s + ","));
            System.out.println("]");
        });
    }

    @Test
    public void permuteUnique1() {
        List<List<Integer>> subsets = new Solution47().permuteUnique(new int[]{1,1,2});
        subsets.forEach(p -> {
            System.out.print("[");
            p.forEach(s -> System.out.print(s + ","));
            System.out.println("]");
        });
    }
}