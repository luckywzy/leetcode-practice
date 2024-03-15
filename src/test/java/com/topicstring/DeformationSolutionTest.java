package com.topicstring;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeformationSolutionTest {

    @Test
    public void isDeformation() {
        assertEquals(false, new DeformationSolution().isDeformation("abc", "abcc"));
        assertEquals(true, new DeformationSolution().isDeformation("123", "321"));
    }
}