package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution17Test {

    @Test
    public void letterCombinations() {
        List<String> letterCombinations = new Solution17().letterCombinations("23");
        List<String> exp = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        exp.forEach(s-> System.out.print(s+","));
        System.out.println();
        letterCombinations.forEach(s-> System.out.print(s+","));

    }

    @Test
    public void letterCombinations1() {
        List<String> letterCombinations = new Solution17().letterCombinations("");
        letterCombinations.forEach(s-> System.out.print(s+","));

    }
}