package com.code.leetcode.editor.cn;

import junit.framework.TestCase;

import java.util.List;

import static com.code.leetcode.editor.cn.Solution102.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/12 10:53 上午
 */
public class Solution102Test extends TestCase {

    public void testLevelOrder() {
        Solution102 solution102 = new Solution102();
        TreeNode treeNode = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        List<List<Integer>> levelOrder = solution102.levelOrder(treeNode);

        levelOrder.forEach(e->{
            e.forEach(System.out::print);
            System.out.print("\n");
        });
    }
}