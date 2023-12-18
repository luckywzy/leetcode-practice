package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution78Test {

    @Test
    public void subsets() {
        List<List<Integer>> subsets = new Solution78().subsets(new int[]{1, 2, 3});
        subsets.forEach(p->{
            System.out.print("[");
            p.forEach(s-> System.out.print(s+","));
            System.out.println("]");
        });
    }
}