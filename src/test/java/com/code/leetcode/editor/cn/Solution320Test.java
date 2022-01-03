package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/27 8:58 下午
 */
public class Solution320Test {

    @Test
    public void generateAbbreviations() {
        Solution320 solution320 = new Solution320();

        List<String> abbreviations = solution320.generateAbbreviations("word");
        Assert.assertEquals(16, abbreviations.size());

        String[] exp = {
                "4", "3d", "2r1", "2rd", "1o2", "1o1d", "1or1", "1ord", "w3", "w2d", "w1r1", "w1rd",
                "wo2", "wo1d", "wor1", "word"
        };
        abbreviations.forEach(System.out::println);
        for (String string : exp) {
            assertTrue(abbreviations.contains(string));
        }

    }
}