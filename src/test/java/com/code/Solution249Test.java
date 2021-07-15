package com.code;

import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/6/4 5:29 下午
 */
public class Solution249Test {

    @Test
    public void groupStrings() {

        Solution249 solution249 = new Solution249();
        String[] prams = new String[]{
                "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"
        };
        System.out.println(solution249.groupStrings(prams).toString());
    }

    @Test
    public void groupStrings1() {

        Solution249 solution249 = new Solution249();
        String[] prams = new String[]{
                "a", "a"
        };
        System.out.println(solution249.groupStrings(prams).toString());
    }
}