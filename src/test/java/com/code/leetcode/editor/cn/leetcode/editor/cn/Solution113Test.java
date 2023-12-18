package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution113Test {

    @Test
    public void pathSum() {
        List<List<Integer>> lists = new Solution113().pathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 3);
        //[[1,2]]
        lists.forEach(s -> {
            s.forEach(a -> System.out.print(a + ","));
            System.out.println();
        });
    }


    @Test
    public void pathSum1() {
        List<List<Integer>> lists = new Solution113().pathSum(
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3)), 3);
        lists.forEach(s -> {
            s.forEach(a -> System.out.print(a + ","));
            System.out.println();
        });
    }


}