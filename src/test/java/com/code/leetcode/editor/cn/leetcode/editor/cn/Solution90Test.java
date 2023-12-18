package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution90Test {

    @Test
    public void subsetsWithDup() {
        List<List<Integer>> subsets = new Solution90().subsetsWithDup(new int[]{1, 2, 2});
        subsets.forEach(p -> {
            System.out.print("[");
            p.forEach(s -> System.out.print(s + ","));
            System.out.println("]");
        });

    }
}