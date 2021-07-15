package com.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/22 12:02 上午
 */
public class Solution163Test {

    @Test
    public void findMissingRanges() {
        ArrayList<String> exp = new ArrayList<>();
        exp.add("2");
        exp.add("4->49");
        exp.add("51->74");
        exp.add("76->99");
        int[] nums = new int[]{0, 1, 3, 50, 75};
        int low=0;
        int upper = 99;
        Assert.assertEquals(exp, new Solution163().findMissingRanges(nums, low, upper));
    }

    @Test
    public void findMissingRanges1() {
        ArrayList<String> exp = new ArrayList<>();
        exp.add("2");
        exp.add("5->49");
        exp.add("51->74");
        exp.add("76->99");
        int[] nums = new int[]{0, 1, 3, 50, 75};
        int low=5;
        int upper = 99;
        Assert.assertEquals(exp, new Solution163().findMissingRanges(nums, low, upper));
    }

    @Test
    public void findMissingRanges2() {
        ArrayList<String> exp = new ArrayList<>();
        exp.add("5->49");
        int[] nums = new int[]{0, 1, 3, 50, 75};
        int low=5;
        int upper = 49;
        Assert.assertEquals(exp, new Solution163().findMissingRanges(nums, low, upper));
    }

    @Test
    public void findMissingRanges3() {
        ArrayList<String> exp = new ArrayList<>();
        exp.add("88->99");
        int[] nums = new int[]{0, 1, 3, 50, 75};
        int low=88;
        int upper = 99;
        Assert.assertEquals(exp, new Solution163().findMissingRanges(nums, low, upper));
    }

}