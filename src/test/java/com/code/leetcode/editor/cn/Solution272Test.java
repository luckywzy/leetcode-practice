package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/11/4 2:20 下午
 */
public class Solution272Test {

    @Test
    public void closestKValues() {
        Solution272 solution272 = new Solution272();
        Solution272.TreeNode root = mockTree(new Integer[]{4,2,5,1,3});
        List<Integer> list = solution272.closestKValues(root, 3.714286D, 2);
        list.sort(Comparator.comparingInt(e->e));
        Integer[] exp = {3, 4};
        for (int i=0; i< exp.length; i++){
            Assert.assertEquals(exp[i], list.get(i));
        }

    }

    @Test
    public void closestKValues1() {
        Solution272 solution272 = new Solution272();
        Solution272.TreeNode root = mockTree(new Integer[]{2,1,3});
        List<Integer> list = solution272.closestKValues(root, 5.571429D, 2);
        list.sort(Comparator.comparingInt(e->e));
        Integer[] exp = {2, 3};
        for (int i=0; i< exp.length; i++){
            Assert.assertEquals(exp[i], list.get(i));
        }
    }
    @Test
    public void closestKValues2() {
        /**
         * [3,2,4,1]
         * 2.000000
         * 3
         */
        Solution272 solution272 = new Solution272();
        Solution272.TreeNode root = mockTree(new Integer[]{3,2,4,1});
        List<Integer> list = solution272.closestKValues(root, 2.000000D, 3);
        list.sort(Comparator.comparingInt(e->e));

        Integer[] exp = {2,1,3};
        ArrayList<Integer> exp1 = new ArrayList<>(Arrays.asList(exp));
        exp1.sort(Comparator.comparingInt(e -> e));

        for (int i=0; i< exp.length; i++){
            Assert.assertEquals(exp1.get(i), list.get(i));
        }
    }

    @Test
    public void closestKValues1_1() {
        Solution272 solution272 = new Solution272();
        Solution272.TreeNode root = mockTree(new Integer[]{4,2,5,1,3});
        List<Integer> list = solution272.closestKValues1(root, 3.714286D, 2);
        list.sort(Comparator.comparingInt(e->e));
        Integer[] exp = {3, 4};
        for (int i=0; i< exp.length; i++){
            Assert.assertEquals(exp[i], list.get(i));
        }

    }

    @Test
    public void closestKValues1_2() {
        Solution272 solution272 = new Solution272();
        Solution272.TreeNode root = mockTree(new Integer[]{2,1,3});
        List<Integer> list = solution272.closestKValues1(root, 5.571429D, 2);
        list.sort(Comparator.comparingInt(e->e));
        Integer[] exp = {2, 3};
        for (int i=0; i< exp.length; i++){
            Assert.assertEquals(exp[i], list.get(i));
        }
    }

    @Test
    public void closestKValues1_3() {
        /**
         * [3,2,4,1]
         * 2.000000
         * 3
         */
        Solution272 solution272 = new Solution272();
        Solution272.TreeNode root = mockTree(new Integer[]{3,2,4,1});
        List<Integer> list = solution272.closestKValues1(root, 2.000000D, 3);
        list.sort(Comparator.comparingInt(e->e));

        Integer[] exp = {2,1,3};
        ArrayList<Integer> exp1 = new ArrayList<>(Arrays.asList(exp));
        exp1.sort(Comparator.comparingInt(e -> e));

        for (int i=0; i< exp.length; i++){
            Assert.assertEquals(exp1.get(i), list.get(i));
        }
    }

    @Test
    public void closestKValues1_4() {
        Solution272 solution272 = new Solution272();
        Solution272.TreeNode root = mockTree(new Integer[]{2,1,3});
        List<Integer> list = solution272.closestKValues1(root, 0.571429D, 2);
        list.sort(Comparator.comparingInt(e->e));
        Integer[] exp = {1, 2};
        for (int i=0; i< exp.length; i++){
            Assert.assertEquals(exp[i], list.get(i));
        }
    }

    Solution272.TreeNode mockTree(Integer[] vals) {
        Solution272.TreeNode treeNode = new Solution272.TreeNode();
        treeNode.val = vals[0];
        doMockTree(treeNode, vals, 1, vals.length - 1);

        return treeNode;
    }

    private void doMockTree(Solution272.TreeNode root, Integer[] vals, int l, int r) {
        if (l > r) {
            return;
        }
        Solution272.TreeNode treeNodeLeft = new Solution272.TreeNode();
        if (vals[l] != null) {
            treeNodeLeft.val = vals[l];
            root.left = treeNodeLeft;
        }
        Solution272.TreeNode treeNodeRight = new Solution272.TreeNode();
        if (l + 1 <= r && vals[l + 1] != null) {
            treeNodeRight.val = vals[l + 1];
            root.right = treeNodeRight;
        }
        if (l + 2 <= r && vals[l + 2] != null) {
            doMockTree(treeNodeLeft, vals, l + 2, r);
        }
        if (l + 4 <= r && vals[l + 4] != null) {
            doMockTree(treeNodeRight, vals, l + 4, r);
        }
    }
}