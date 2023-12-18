package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution131Test {

    @Test
    public void partition() {
        List<List<String>> partition = new Solution131().partition("aab");
        partition.forEach(p->{
            p.forEach(s-> System.out.print(s+","));
            System.out.println();
        });
    }

    @Test
    public void partition1() {
        List<List<String>> partition = new Solution131().partition("a");
        partition.forEach(p->{
            p.forEach(s-> System.out.print(s+","));
            System.out.println();
        });
    }

    @Test
    public void partition2() {
        List<List<String>> partition = new Solution131().partition("abababababa");
        partition.forEach(p->{
            p.forEach(s-> System.out.print(s+","));
            System.out.println();
        });
    }
}