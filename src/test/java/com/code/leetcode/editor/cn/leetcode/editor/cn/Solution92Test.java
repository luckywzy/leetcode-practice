package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution92Test {

    @Test
    public void reverseBetween() {
        ListNode node = new Solution92().reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4);
        while (node != null){
            System.out.print(node.val+",");
            node = node.next;
        }
    }
}