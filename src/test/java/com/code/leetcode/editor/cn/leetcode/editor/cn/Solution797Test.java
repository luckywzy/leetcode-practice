package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution797Test {

    @Test
    public void allPathsSourceTarget() {
        List<List<Integer>> allPathsSourceTarget = new Solution797().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        for (int i = 0; i < allPathsSourceTarget.size(); i++) {
            allPathsSourceTarget.get(i).forEach(k-> System.out.print(k+","));
            System.out.println();
        }
    }
}