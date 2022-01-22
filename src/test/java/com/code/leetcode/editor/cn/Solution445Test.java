package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/13 11:53 上午
 */
public class Solution445Test {

    @Test
    public void addTwoNumbers() {
        //l1 = [7,2,4,3], l2 = [5,6,4]
        Solution445 solution445 = new Solution445();
        Solution445.ListNode l1 = new Solution445.ListNode(7,
                new Solution445.ListNode(2, new Solution445.ListNode(4, new Solution445.ListNode(3))));
        Solution445.ListNode l2 = new Solution445.ListNode(5, new Solution445.ListNode(6, new Solution445.ListNode(4)));
        Solution445.ListNode listNode = solution445.addTwoNumbers(l1, l2);
        int[] exp = new int[]{7, 8, 0, 7};
        int i = 0;
        while (listNode != null) {
            //[7,8,0,7]
            Assert.assertEquals(exp[i++], listNode.val);
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    @Test
    public void addTwoNumbers2() {
        Solution445 solution445 = new Solution445();
        Solution445.ListNode l1 = new Solution445.ListNode(5);
        Solution445.ListNode l2 = new Solution445.ListNode(5);
        Solution445.ListNode listNode = solution445.addTwoNumbers(l1, l2);
        int[] exp = new int[]{1, 0};
        int i = 0;
        while (listNode != null) {
            //[7,8,0,7]
            Assert.assertEquals(exp[i++], listNode.val);
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    @Test
    public void addTwoNumbers3() {
        Solution445 solution445 = new Solution445();
        Solution445.ListNode l1 = new Solution445.ListNode(1);
        Solution445.ListNode l2 = new Solution445.ListNode(9, new Solution445.ListNode(9));
        Solution445.ListNode listNode = solution445.addTwoNumbers(l1, l2);
        int[] exp = new int[]{1, 0, 0};
        int i = 0;
        while (listNode != null) {
            //[7,8,0,7]
            Assert.assertEquals(exp[i++], listNode.val);
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}