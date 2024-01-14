package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution22Test {

    @Test
    public void generateParenthesis() {
        List<String> strings = new Solution22().generateParenthesis(3);
        strings.forEach(System.out::println);
    }

    @Test
    public void generateParenthesis1() {
        List<String> strings = new Solution22().generateParenthesis(4);
        strings.forEach(System.out::println);
    }
}