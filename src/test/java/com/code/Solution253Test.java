package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/6/22 3:14 下午
 */
public class Solution253Test {

    @Test
    public void minMeetingRooms() {
        int[][] in = {{0, 30}, {5, 10}, {15, 20}};
        Solution253 solution253 = new Solution253();

        Assert.assertEquals(2, solution253.minMeetingRooms(in));
    }


    @Test
    public void minMeetingRooms1() {
        int[][] in = {{0, 30}, {5, 10}, {6, 17}, {15, 20}};
        Solution253 solution253 = new Solution253();

        Assert.assertEquals(3, solution253.minMeetingRooms(in));
    }

    @Test
    public void minMeetingRooms2() {
        int[][] in = {{13, 15}, {1, 13}};
        Solution253 solution253 = new Solution253();

        Assert.assertEquals(1, solution253.minMeetingRooms(in));
    }

    @Test
    public void minMeetingRooms3() {
        int[][] in = {{9,10}, {4,9},{4,17}};
        Solution253 solution253 = new Solution253();

        Assert.assertEquals(2, solution253.minMeetingRooms(in));
    }

    @Test
    public void minMeetingRooms4() {
        int[][] in = {{1,8}, {6,20},{9,16},{13,17}};
        Solution253 solution253 = new Solution253();

        Assert.assertEquals(3, solution253.minMeetingRooms(in));
    }
}