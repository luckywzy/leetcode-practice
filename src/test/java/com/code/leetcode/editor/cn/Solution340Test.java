package com.code.leetcode.editor.cn;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/5 8:46 下午
 */
public class Solution340Test extends TestCase {

    public void testLengthOfLongestSubstringKDistinct() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct("eceba", 2);
        Assert.assertEquals(3, eceba);
    }

    public void testLengthOfLongestSubstringKDistinct2() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct("aa", 1);
        Assert.assertEquals(2, eceba);
    }

    public void testLengthOfLongestSubstringKDistinct3() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct("a", 2);
        Assert.assertEquals(1, eceba);
    }

    public void testLengthOfLongestSubstringKDistinct4() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct("aa", 0);
        Assert.assertEquals(0, eceba);
    }
    public void testLengthOfLongestSubstringKDistinct5() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct("aba", 1);
        Assert.assertEquals(1, eceba);
    }

    public void testLengthOfLongestSubstringKDistinct6() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct("nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy", 25);
        Assert.assertEquals(70, eceba);
    }


    public void testLengthOfLongestSubstringKDistinct2_1() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct2("eceba", 2);
        Assert.assertEquals(3, eceba);
    }

    public void testLengthOfLongestSubstringKDistinct2_2() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct2("aa", 1);
        Assert.assertEquals(2, eceba);
    }

    public void testLengthOfLongestSubstringKDistinct2_3() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct2("a", 2);
        Assert.assertEquals(1, eceba);
    }

    public void testLengthOfLongestSubstringKDistinct2_4() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct2("aa", 0);
        Assert.assertEquals(0, eceba);
    }
    public void testLengthOfLongestSubstringKDistinct2_5() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct2("aba", 1);
        Assert.assertEquals(1, eceba);
    }

    public void testLengthOfLongestSubstringKDistinct2_6() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct2("nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy", 25);
        Assert.assertEquals(70, eceba);
    }

    public void testLengthOfLongestSubstringKDistinct2_7() {
        Solution solution = new Solution();
        int eceba = solution.lengthOfLongestSubstringKDistinct2("abee", 1);
        Assert.assertEquals(2, eceba);
    }
}