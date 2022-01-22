package com.code.leetcode.editor.cn;

//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
// Related Topics 栈 链表 数学 👍 462 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ll1 = reverse(l1);
        ListNode ll2 = reverse(l2);
        return add(ll1, ll2);
    }

    private ListNode add(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode head = new ListNode();
        ListNode r = head;
        int jw = 0;
        while (c1 != null || c2 != null) {
            int i = 0;
            if (c1 != null) {
                i = i + c1.val;
            }
            if (c2 != null) {
                i = i + c2.val;
            }
            i = i + jw;
            int p = i / 10;
            if (p != 0) {
                i = i - 10;
            }
            jw = p;
            r.next = new ListNode(i);
            r = r.next;
            if (c1 != null) {
                c1 = c1.next;
            }
            if (c2 != null) {
                c2 = c2.next;
            }
        }
        if (jw > 0) {
            r.next = new ListNode(jw);
        }
        return reverse(head.next);
    }

    private ListNode reverse(ListNode l1) {
        ListNode prev = null;
        ListNode nxt = l1;
        while (nxt != null) {
            ListNode p = nxt.next;
            nxt.next = prev;

            prev = nxt;
            nxt = p;
        }
        return prev;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
