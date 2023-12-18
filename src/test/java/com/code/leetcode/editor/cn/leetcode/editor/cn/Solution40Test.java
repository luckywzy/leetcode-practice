package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution40Test {

    @Test
    public void combinationSum2() {
        List<List<Integer>> combinationSum2 = new Solution40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        combinationSum2.forEach(ss->{
            ss.forEach(s-> System.out.print(s+","));
            System.out.println();
        });
    }

    @Test
    public void combinationSum2_1() {
        List<List<Integer>> combinationSum2 = new Solution40().combinationSum2(new int[]{2,5,2,1,2}, 5);
        // [ [1,2,2], [5] ]
        combinationSum2.forEach(ss->{
            ss.forEach(s-> System.out.print(s+","));
            System.out.println();
        });
    }
    @Test
    public void combinationSum2_2() {
        List<List<Integer>> combinationSum2 = new Solution40().combinationSum2(new int[]{1,1,2}, 3);
        // [ [1,2,2], [5] ]
        combinationSum2.forEach(ss->{
            ss.forEach(s-> System.out.print(s+","));
            System.out.println();
        });
    }
}