package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution103Test {

    @Test
    public void zigzagLevelOrder() {
        List<List<Integer>> zigzagLevelOrder = new Solution103().zigzagLevelOrder(new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                new TreeNode(15), new TreeNode(7))));
        zigzagLevelOrder.forEach(lv ->{
            lv.forEach(n -> System.out.print(n + ","));
            System.out.println();
        });
    }

    @Test
    public void zigzagLevelOrder_1() {
        List<List<Integer>> zigzagLevelOrder = new Solution103().zigzagLevelOrder(new TreeNode(3));
        zigzagLevelOrder.forEach(lv ->{
            lv.forEach(n -> System.out.print(n + ","));
            System.out.println();
        });
    }
}