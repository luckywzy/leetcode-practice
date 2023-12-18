package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution199Test {

    @Test
    public void rightSideView() {
        List<Integer> integers = new Solution199().rightSideView(new TreeNode(2, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(15))));
        integers.forEach(x -> {
            System.out.print(x + " \n");
        });
    }

    @Test
    public void rightSideView1() {
        List<Integer> integers = new Solution199().rightSideView(new TreeNode(1, new TreeNode(2,null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4))));
        integers.forEach(x -> {
            System.out.print(x + " \n");
        });
    }
}