package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/6/18 4:16 下午
 */
public class Vector2D251Test {

    @Test
    public void next() {
        Vector2D_251 iterator = new Vector2D_251(new int[][]{{1, 2}, {3}, {4}});

        Assert.assertEquals(1, iterator.next()); // 返回 1
        Assert.assertEquals(2, iterator.next()); // 返回 2
        Assert.assertEquals(3, iterator.next()); // 返回 3
        Assert.assertEquals(true, iterator.hasNext()); // 返回 true
        Assert.assertEquals(true, iterator.hasNext()); // 返回 true
        Assert.assertEquals(4, iterator.next()); // 返回 4
        Assert.assertEquals(false, iterator.hasNext()); // 返回 false
    }

    @Test
    public void next1() {

        Vector2D_251 iterator = new Vector2D_251(new int[][]{{}, {}, {},{1,2}});

        Assert.assertEquals(true, iterator.hasNext()); // 返回 true
        Assert.assertEquals(0, iterator.next()); // 返回 1
        Assert.assertEquals(0, iterator.next()); // 返回 2
        Assert.assertEquals(0, iterator.next()); // 返回 3
        Assert.assertEquals(true, iterator.hasNext()); // 返回 true
        Assert.assertEquals(4, iterator.next()); // 返回 4
        Assert.assertEquals(false, iterator.hasNext()); // 返回 false
    }
}