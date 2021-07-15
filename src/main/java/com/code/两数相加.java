package com.code;

/**
 * @Author: wangzongyu
 * @Date: 2019/4/14 10:43
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class 两数相加 {


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode h1 = l1;
		ListNode h2 = l2;
		ListNode res = new ListNode(0);
		ListNode head = res;
		int inc = 0;
		while (true){
			int cur = 0;
			if(h1 != null){
				cur += h1.val;
				h1 = h1.next;
			}
			if(h2 != null){
				cur += h2.val;
				h2 = h2.next;
			}
			//进位位不为空的时候
			if(inc != 0){
				cur += inc;
				//重置进位位
				inc = 0;
			}
			//需要进位
			if(cur  >= 10){
				inc = cur / 10;
				cur = cur % 10;
			}

			res.next = new ListNode(cur);

			res = res.next;
			if(h1 == null && h2 == null ){
				//5+5 时 产生进位多出来一位
				if(inc != 0){
					res.next = new ListNode(inc);
				}
				break;
			}
		}
		return head.next;
	}


	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
