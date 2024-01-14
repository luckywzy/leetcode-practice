package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution143Test {

    @Test
    public void reorderList() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        new Solution143().reorderList(node);
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }
}