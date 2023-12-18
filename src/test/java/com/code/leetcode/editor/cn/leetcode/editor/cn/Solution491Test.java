package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution491Test {

    @Test
    public void findSubsequences() {
        List<List<Integer>> subsets = new Solution491().findSubsequences(new int[]{4, 6, 7, 7});
        subsets.forEach(p -> {
            System.out.print("[");
            p.forEach(s -> System.out.print(s + ","));
            System.out.println("]");
        });

    }
}