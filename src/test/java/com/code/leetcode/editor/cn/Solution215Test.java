package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/16 5:40 下午
 */
public class Solution215Test {

    @Test
    public void findKthLargest() {
        Solution215 solution215 = new Solution215();
        int kthLargest = solution215.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        Assert.assertEquals(5, kthLargest);
    }
}