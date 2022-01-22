package com.code;


import com.code.leetcode.editor.cn.Solution3;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/8 3:56 下午
 */
public class Solution3Test {

    @Test
    public void lengthOfLongestSubstring1() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(3, substring);
    }


    @Test
    public void lengthOfLongestSubstring2() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(1, substring);
    }


    @Test
    public void lengthOfLongestSubstring3() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(3, substring);
    }

    @Test
    public void lengthOfLongestSubstring4() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring(" ");
        Assert.assertEquals(1, substring);
    }

    @Test
    public void lengthOfLongestSubstring5() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring("dvdf");
        Assert.assertEquals(3, substring);
    }

    @Test
    public void lengthOfLongestSubstring6() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring("tmmzuxt");
        Assert.assertEquals(5, substring);
    }


    @Test
    public void lengthOfLongestSubstring2_1() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring2("abcabcbb");
        Assert.assertEquals(3, substring);
    }


    @Test
    public void lengthOfLongestSubstring2_2() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring2("bbbbb");
        Assert.assertEquals(1, substring);
    }


    @Test
    public void lengthOfLongestSubstring2_3() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring2("pwwkew");
        Assert.assertEquals(3, substring);
    }

    @Test
    public void lengthOfLongestSubstring2_4() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring2(" ");
        Assert.assertEquals(1, substring);
    }

    @Test
    public void lengthOfLongestSubstring2_5() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring2("dvdf");
        Assert.assertEquals(3, substring);
    }

    @Test
    public void lengthOfLongestSubstring2_6() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring2("tmmzuxt");
        Assert.assertEquals(5, substring);
    }

    /**
     * --------------------3--------------
     */
    @Test
    public void lengthOfLongestSubstring3_1() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring3("abcabcbb");
        Assert.assertEquals(3, substring);
    }


    @Test
    public void lengthOfLongestSubstring3_2() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring3("bbbbb");
        Assert.assertEquals(1, substring);
    }


    @Test
    public void lengthOfLongestSubstring3_3() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring3("pwwkew");
        Assert.assertEquals(3, substring);
    }

    @Test
    public void lengthOfLongestSubstring3_4() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring3(" ");
        Assert.assertEquals(1, substring);
    }

    @Test
    public void lengthOfLongestSubstring3_5() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring3("dvdf");
        Assert.assertEquals(3, substring);
    }

    @Test
    public void lengthOfLongestSubstring3_6() {
        Solution3 solution = new Solution3();
        int substring = solution.lengthOfLongestSubstring3("tmmzuxt");
        Assert.assertEquals(5, substring);
    }
}