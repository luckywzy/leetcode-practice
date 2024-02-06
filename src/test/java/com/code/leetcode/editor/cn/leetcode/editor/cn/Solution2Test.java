package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {

    @Test
    public void addTwoNumbers() {
        ListNode twoNumbers = new Solution2().addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4))));

        twoNumbers.PrintAll();
    }

    @Test
    public void addTwoNumbers1() {
        ListNode twoNumbers = new Solution2().addTwoNumbers(
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));

        twoNumbers.PrintAll();
    }
}