package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2732 👎 0


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
class Solution19 {
    //快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dmy = new ListNode(0, head);
        ListNode fast = dmy;
       for( int i = 0; i <= n; i++ ){
           fast = fast.next;
       }
        ListNode slow = dmy;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dmy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new Solution19().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 1);
        while (listNode != null){
            System.out.print(listNode.val +",");
            listNode = listNode.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
