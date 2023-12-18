package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class Solution226Test {

    @Test
    public void invertTree() {
        TreeNode treeNode = new Solution226().invertTree(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4))));
        showTree(treeNode);
    }


    public  static  void showTree(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return ;
        }
        queue.add(root);
        TreeNode last = root;
        List<Integer> itemList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            itemList.add(node.val);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
            if (last == node){
                res.add(itemList);
                itemList = new ArrayList<>();
                last = queue.peekLast();
            }
        }
        res.forEach(x -> {
            x.forEach(a -> {
                System.out.print(a + " \t");
            });
            System.out.println();
        });
    }
}