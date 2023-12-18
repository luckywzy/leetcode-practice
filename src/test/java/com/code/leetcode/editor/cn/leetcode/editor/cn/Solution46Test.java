package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution46Test {

    @Test
    public void permute() {
        List<List<Integer>> subsets = new Solution46().permute(new int[]{1,2,3});
        subsets.forEach(p -> {
            System.out.print("[");
            p.forEach(s -> System.out.print(s + ","));
            System.out.println("]");
        });
    }
}