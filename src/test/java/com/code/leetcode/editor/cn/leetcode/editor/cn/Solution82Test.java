package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution82Test {

    @Test
    public void deleteDuplicates() {
        ListNode node = new Solution82().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))));
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}