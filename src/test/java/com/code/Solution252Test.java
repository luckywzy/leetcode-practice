package com.code;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/6/19 3:34 下午
 */
public class Solution252Test {

    @Test
    public void canAttendMeetings() {

        Solution252 solution252 = new Solution252();
        int[][] k = {{7, 10}, {2, 4}};
        assertTrue(solution252.canAttendMeetings(k));
    }


    @Test
    public void canAttendMeetings2() {

        Solution252 solution252 = new Solution252();
        int[][] k = {{0, 30}, {5, 10}, {15, 20}};
        assertFalse(solution252.canAttendMeetings(k));
    }
}