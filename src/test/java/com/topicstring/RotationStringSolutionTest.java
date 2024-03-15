package com.topicstring;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotationStringSolutionTest {

    @Test
    public void isRotation() {
        assertEquals(true, new RotationStringSolution().isRotation("cdab", "abcd"));
        assertEquals(false, new RotationStringSolution().isRotation("1ab2", "ab12"));
        assertEquals(true, new RotationStringSolution().isRotation("2ab1", "ab12"));
    }
}