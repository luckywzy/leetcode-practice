package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/22 7:25 下午
 */
public class Solution1055Test {

    @Test
    public void shortestWay() {
        Solution1055 solution1055 = new Solution1055();
        //source = "xyz", target = "xzyxz"
        int shortestWay = solution1055.shortestWay("xyz", "xzyxz");
        Assert.assertEquals(3, shortestWay);
    }

    @Test
    public void shortestWay2() {
        Solution1055 solution1055 = new Solution1055();
        //source = "xyz", target = "xzyxz"
        int shortestWay = solution1055.shortestWay("abc", "acdbc");
        Assert.assertEquals(-1, shortestWay);
    }

    @Test
    public void shortestWay3() {
        Solution1055 solution1055 = new Solution1055();
        //source = "xyz", target = "xzyxz"
        int shortestWay = solution1055.shortestWay("ugxhfjvmzvkzzlmpryyiqxcujshflkreqqorcbefzvjsnfokfydgajitaqcsqlywizwvkjsqjqpjagvf", "rfuexnetdlhtlniubuqmalbrmmxrzhmkrzcwswytnudndovcwbixttqrqnsglyhkmbwphztjottflnoj");
        Assert.assertEquals(30, shortestWay);
    }
}