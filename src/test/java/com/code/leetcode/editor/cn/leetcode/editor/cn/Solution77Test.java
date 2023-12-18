package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution77Test {

    @Test
    public void combine() {
        List<List<Integer>> combine = new Solution77().combine(4, 2);
        //[2,4], [3,4], [2,3], [1,2], [1,3], [1,4]
        combine.forEach(e -> {
            e.forEach(x -> System.out.print(x + ","));
            System.out.println();
        });
    }
    @Test
    public void combine1() {
        List<List<Integer>> combine = new Solution77().combine(1, 1);
        //1
        combine.forEach(e -> {
            e.forEach(x -> System.out.print(x + ","));
            System.out.println();
        });
    }
}