package com.topicstring;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumSumSolutionTest {

    @Test
    public void numSum() {
        assertEquals(4, new NumSumSolution().numSum("A1.3"));
        assertEquals(11, new NumSumSolution().numSum(" A-1BC--12"));
        assertEquals(7, new NumSumSolution().numSum("A-1B--2C--D6"));
    }
}