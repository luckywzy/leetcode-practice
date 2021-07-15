package com.code;

import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2019/4/14 11:20
 */
public class 两数相加Test {

	@Test
	public void addTwoNumbers() {
		两数相加.ListNode node10 = new 两数相加.ListNode(9);
		两数相加.ListNode node11 = new 两数相加.ListNode(4);
		两数相加.ListNode node12 = new 两数相加.ListNode(3);
		node10.next = node11; node11.next = node12;
		两数相加.ListNode node20 = new 两数相加.ListNode(5);
		两数相加.ListNode node21 = new 两数相加.ListNode(6);
		两数相加.ListNode node22 = new 两数相加.ListNode(4);
		两数相加.ListNode node23 = new 两数相加.ListNode(4);
		node20.next = node21; node21.next = node22; node22.next = node23;

		两数相加 so = new 两数相加();
		两数相加.ListNode res = so.addTwoNumbers(node10, node20);
		while (res != null){
			System.out.println(res.val+"-");
			res = res.next;
		}
	}
	@Test
	public void addTwoNumbers_5_5() {
		两数相加.ListNode node10 = new 两数相加.ListNode(5);
		两数相加.ListNode node20 = new 两数相加.ListNode(5);

		两数相加 so = new 两数相加();
		两数相加.ListNode res = so.addTwoNumbers(node10, node20);
		while (res != null){
			System.out.println(res.val+"-");
			res = res.next;
		}
	}
}