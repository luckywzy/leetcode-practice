package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution86Test {

    @Test
    public void partition() {
        // 1,4,3,2,5,2
        ListNode partition = new Solution86().partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3);
        partition.PrintAll();
    }
}