package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution406Test {

    @Test
    public void reconstructQueue() {
        int[][] queue = new Solution406().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        Arrays.stream(queue).forEach(e->{
            System.out.println("["+e[0]+","+e[1]+"]");
        });
    }
}