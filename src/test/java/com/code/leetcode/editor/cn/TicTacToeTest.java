package com.code.leetcode.editor.cn;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/5 10:47 下午
 */
public class TicTacToeTest extends TestCase {

    public void testMove() {
        TicTacToe ticTacToe = new TicTacToe(4);
        ticTacToe.move(0, 3, 1);
        ticTacToe.move(3, 3, 2);
        ticTacToe.move(3, 0, 1);
        ticTacToe.move(0, 0, 2);
        ticTacToe.move(2, 1, 1);
        ticTacToe.move(2, 2, 2);
        int winner = ticTacToe.move(1, 2, 1);
        Assert.assertEquals(1, winner);
    }
}