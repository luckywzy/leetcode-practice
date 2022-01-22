package com.code.leetcode.editor.cn;

//给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// 
//
// 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 27 👎 0


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
class Solution077 {
    /**
     * 链表的归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int n = 0;
        ListNode h = head;
        while (h != null) {
            h = h.next;
            n++;
        }
        return sort(head, 0, n - 1);
    }

    private ListNode sort(ListNode head, int l, int h) {
        if (l == h) {
            return head;
        }
        //寻找分割点
        int mid = (h + l) >> 1;
        ListNode t = head;
        int i = l;
        while (i < mid) {
            t = t.next;
            i++;
        }
        ListNode p = t.next;
        //将两个链表分割开
        t.next = null;
        return merge(sort(head, l, mid), sort(p, mid + 1, h));
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode sb = new ListNode();
        ListNode node = sb;
        //归并
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                node.next = h1;
                h1 = h1.next;
            } else {
                node.next = h2;
                h2 = h2.next;
            }
            node = node.next;
        }
        ListNode t = h1 != null ? h1 : h2;

        while (t != null) {
            node.next = t;
            node = node.next;
            t = t.next;
        }
        return sb.next;
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
