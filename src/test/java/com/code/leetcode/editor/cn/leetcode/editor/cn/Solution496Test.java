package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution496Test {

    @Test
    public void nextGreaterElement() {
        int[] greaterElement = new Solution496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int i = 0; i < greaterElement.length; i++){
            System.out.print(greaterElement[i] +",");
        }
    }
}