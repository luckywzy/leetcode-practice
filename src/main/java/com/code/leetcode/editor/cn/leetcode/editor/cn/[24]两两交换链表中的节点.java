package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2084 👎 0


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
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode node = head.next;
        ListNode newNode = swapPairs(node.next);

        node.next = head;
        head.next = newNode;

        return node;
    }

    public static void main(String[] args) {
//        getListNode(new ListNode(1));
//        getListNode(new ListNode(1, new ListNode(2)));
//        getListNode(new ListNode(1, new ListNode(2, new ListNode(3))));
        getListNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    private static ListNode getListNode(ListNode listNode) {
        ListNode node1 = new Solution24().swapPairs(listNode);
        while (node1 != null) {
            System.out.print(node1.val + "  ");
            node1 = node1.next;
        }
        System.out.println("\n");
        return node1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
