package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/20 11:58 上午
 */
public class Solution245Test {

    @Test
    public void shortestWordDistance() {
        Solution245 solution245 = new Solution245();
        int distance = solution245.shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes");
        Assert.assertEquals(3, distance);
    }

    @Test
    public void shortestWordDistance2() {
        Solution245 solution245 = new Solution245();
        int distance = solution245.shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding");
        Assert.assertEquals(1, distance);
    }
}