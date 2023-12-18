package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution39Test {

    @Test
    public void combinationSum() {
        List<List<Integer>> combinationSum = new Solution39().combinationSum(new int[]{2, 3, 6, 7}, 7);
        //[[2,2,3],[7]]
        combinationSum.forEach(ss->{
            ss.forEach(s-> System.out.print(s+","));
            System.out.println();
        });
    }

    @Test
    public void combinationSum1() {
        List<List<Integer>> combinationSum = new Solution39().combinationSum(new int[]{2, 3, 5}, 8);
        //[[2,2,2,2],[2,3,3],[3,5]]
        combinationSum.forEach(ss->{
            ss.forEach(s-> System.out.print(s+","));
            System.out.println();
        });
    }

    @Test
    public void combinationSum3() {
        List<List<Integer>> combinationSum = new Solution39().combinationSum(new int[]{2, 5, 3}, 8);
        //[[2,2,2,2],[2,3,3],[3,5]]
        combinationSum.forEach(ss->{
            ss.forEach(s-> System.out.print(s+","));
            System.out.println();
        });
    }

    @Test
    public void combinationSum2() {
        List<List<Integer>> combinationSum = new Solution39().combinationSum(new int[]{2}, 1);
        //[]
        combinationSum.forEach(ss->{
            ss.forEach(s-> System.out.print(s+","));
            System.out.println();
        });
    }
}