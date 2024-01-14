package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1431 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution143 {
    /**
     * 思路1： 使用map 将 链表节点存起来
     * 思路 2：使用快慢指针，将后半截链表倒置，然后依次插入到前半截链表中
     * @param head
     */
    public void reorderList(ListNode head) {
        helper(head);
    }

    ListNode helper(ListNode node){
        if(node.next == null){

            return node;
        }
        ListNode last = helper(node.next);
        ListNode next = node.next;
        node.next = last;
        ListNode outTail = last.next;
        last.next = next;
        return outTail;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
