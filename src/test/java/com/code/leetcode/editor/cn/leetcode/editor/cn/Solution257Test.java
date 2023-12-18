package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution257Test {

    @Test
    public void binaryTreePaths() {
        List<String> treePaths = new Solution257().binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3)));
        treePaths.forEach(System.out::println);
    }

}