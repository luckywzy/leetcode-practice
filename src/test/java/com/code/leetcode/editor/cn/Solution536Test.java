package com.code.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/19 12:54 下午
 */
public class Solution536Test {

    @Test
    public void str2tree() {
        Solution536 solution536 = new Solution536();
        Solution536.TreeNode treeNode = solution536.str2tree("4(2(3)(1))(6(5))");
        sout(treeNode);
    }

    private void sout(Solution536.TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            sout(treeNode.left);
            sout(treeNode.right);
        }
    }
}