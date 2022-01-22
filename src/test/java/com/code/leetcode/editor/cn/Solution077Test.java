package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/13 9:47 下午
 */
public class Solution077Test {

    @Test
    public void sortList() {
        Solution077 solution077 = new Solution077();
        //[4,2,1,3]
        Solution077.ListNode listNode = new Solution077.ListNode(4, new Solution077.ListNode(2, new Solution077.ListNode(1, new Solution077.ListNode(3))));
        Solution077.ListNode res = solution077.sortList(listNode);
        int[] exp = {1, 2, 3, 4};
        for (int i : exp) {
            Assert.assertEquals(i, res.val);
            res = res.next;
        }

    }
}