package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 10367 👎 0


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
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }


    ListNode add(ListNode l1, ListNode l2, int tip) {
        int sum = tip;
        if (l1 != null && l2 != null) {
            sum = sum + l1.val + l2.val;
        } else if (l1 == null && l2 != null) {
            sum += l2.val;
        } else if (l1 != null) {
            sum += l1.val;
        } else if (tip == 0) {
            return null;
        }

        int plus = 0;
        if (sum >= 10) {
            plus = sum / 10;
            sum = sum % 10;
        }
        ListNode node = new ListNode(sum);
        node.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, plus);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
