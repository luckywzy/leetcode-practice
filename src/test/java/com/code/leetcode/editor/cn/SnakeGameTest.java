package com.code.leetcode.editor.cn;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/6 12:00 上午
 */
public class SnakeGameTest extends TestCase {

    public void testMove() {
        SnakeGame snakeGame = new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
        snakeGame.move("R");
        snakeGame.move("D");
        snakeGame.move("R");
        snakeGame.move("U");
        int l = snakeGame.move("L");
        Assert.assertEquals(2, l);
        snakeGame.move("U");
    }


    public void testMove2() {
        SnakeGame snakeGame = new SnakeGame(3, 3, new int[][]{
                {2,0},{0,0},{0,2},{2,2}});
        snakeGame.move("D");
        snakeGame.move("D");
        snakeGame.move("R");
        snakeGame.move("U");
        snakeGame.move("U");
        snakeGame.move("L");
        snakeGame.move("D");
        snakeGame.move("R");
        snakeGame.move("R");
        snakeGame.move("U");
        snakeGame.move("L");
        int l = snakeGame.move("D");
        Assert.assertEquals(3, l);
    }
}