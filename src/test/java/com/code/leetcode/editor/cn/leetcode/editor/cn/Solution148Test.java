package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution148Test {

    @Test
    public void sortList() {
        ListNode node = new Solution148().sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        while (node != null){
            System.out.print(node.val+",");
            node = node.next;
        }
        System.out.println();
        ListNode node1 = new Solution148().sortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0))))));
        while (node1 != null){
            System.out.print(node1.val+",");
            node1 = node1.next;
        }
    }
}