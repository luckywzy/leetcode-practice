package com.code.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/20 4:17 下午
 */
public class Solution249Test {

    @Test
    public void groupStrings() {
        Solution249 solution249 = new Solution249();
        List<List<String>> lists = solution249.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
        for (List<String> list : lists) {
            list.forEach(s -> System.out.print(s + "\t"));
            System.out.println();
        }

    }
}