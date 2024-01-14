package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution763Test {

    @Test
    public void partitionLabels() {
        List<Integer> list = new Solution763().partitionLabels("ababcbacadefegdehijhklij");
        list.forEach(System.out::println);
    }

    @Test
    public void partitionLabels1() {
        List<Integer> list = new Solution763().partitionLabels("eccbbbbdec");
        list.forEach(System.out::println);
    }
}