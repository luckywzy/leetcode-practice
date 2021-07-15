package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/22 5:09 下午
 */
public class Solution243Test {

    @Test
    public void shortestDistance() {
        String[] di = new String[]{"practice", "makes", "perfect", "coding", "makes"};

        Assert.assertEquals(3, new Solution243().shortestDistance(di,
                "coding", "practice"));

        Assert.assertEquals(1, new Solution243().shortestDistance(di,
                "makes", "coding"));
    }

    @Test
    public void shortestDistance1() {
        String[] di = new String[]{"a", "a", "b", "b"};

        Assert.assertEquals(1, new Solution245().shortestDistance(di,
                "a", "b"));
    }
    @Test
    public void shortestDistance3() {
        String[] di = new String[]{"a", "a", "b", "b"};

        Assert.assertEquals(1, new Solution243().shortestDistance(di,
                "b", "b"));
    }
}