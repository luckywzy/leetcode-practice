package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution93Test {

    @Test
    public void restoreIpAddresses() {
        List<String> addresses = new Solution93().restoreIpAddresses("25525511135");
        //["255.255.11.135","255.255.111.35"]
        addresses.forEach(System.out::println);
    }
}