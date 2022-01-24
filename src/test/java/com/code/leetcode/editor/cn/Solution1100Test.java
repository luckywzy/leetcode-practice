package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/24 11:07 上午
 */
public class Solution1100Test {

    @Test
    public void numKLenSubstrNoRepeats() {
        Solution1100 solution1100 = new Solution1100();
        int havefunonleetcode = solution1100.numKLenSubstrNoRepeats("havefunonleetcode", 5);
        Assert.assertEquals(6, havefunonleetcode);
    }
}