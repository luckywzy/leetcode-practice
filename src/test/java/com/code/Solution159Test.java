package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/21 5:30 下午
 */
public class Solution159Test {

    @Test
    public void lengthOfLongestSubstringTwoDistinct() {
        Assert.assertEquals(1, new Solution159().lengthOfLongestSubstringTwoDistinct("a"));
        Assert.assertEquals(3, new Solution159().lengthOfLongestSubstringTwoDistinct("eceba"));
        Assert.assertEquals(5, new Solution159().lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        Assert.assertEquals(7, new Solution159().lengthOfLongestSubstringTwoDistinct("abababa"));
    }
}