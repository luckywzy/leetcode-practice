package com.code.leetcode.editor.cn;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/6 8:49 下午
 */
public class Solution361Test extends TestCase {

    public void testMaxKilledEnemies() {
        Solution361 solution361 = new Solution361();
        int killedEnemies = solution361.maxKilledEnemies(new char[][]{{'0', 'E', '0', 'W'}});
        Assert.assertEquals(1, killedEnemies);
    }
}