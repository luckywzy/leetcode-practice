package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1355 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 */
class ListNode {
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

    void PrintAll() {
        ListNode node = this;
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(",");
            }
            node = node.next;
        }
        System.out.print("]" + "\n");
    }
}

class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode vHead = new ListNode();
        vHead.next = head;

        ListNode node = vHead;
        while (node.next != null) {
            ListNode next = node.next;
            if (next.val == val) {
                node.next = next.next;
            } else {
                node = node.next;
            }
        }

        return vHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
