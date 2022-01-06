package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static com.code.leetcode.editor.cn.Solution298.*;
import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/4 11:28 下午
 */
public class Solution333Test {

    @Test
    public void largestBSTSubtree() {

        Solution333 solution333 = new Solution333();
        TreeNode treeNode =
                new TreeNode(10,
                        new TreeNode(5,
                                new TreeNode(1),
                                new TreeNode(8)),
                        new TreeNode(15, null,
                                new TreeNode(7)));

        int largestBSTSubtree = solution333.largestBSTSubtree(treeNode);
        Assert.assertEquals(3, largestBSTSubtree);
    }


    @Test
    public void largestBSTSubtree1() {
//[3,2,4,null,null,1]
        Solution333 solution333 = new Solution333();
        TreeNode treeNode =
                new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4,
                                new TreeNode(1),
                                null));

        int largestBSTSubtree = solution333.largestBSTSubtree(treeNode);
        Assert.assertEquals(2, largestBSTSubtree);
    }
}