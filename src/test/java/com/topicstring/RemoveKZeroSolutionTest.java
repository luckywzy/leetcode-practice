package com.topicstring;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveKZeroSolutionTest {

    @Test
    public void removeKZero() {
        assertEquals("ab", new RemoveKZeroSolution().removeKZero("a00b", 2));
        assertEquals("a0000b", new RemoveKZeroSolution().removeKZero("a0000b000", 3));

        assertEquals("ab", new RemoveKZeroSolution().removeKZero1("a00b", 2));
        assertEquals("a0000b", new RemoveKZeroSolution().removeKZero1("a0000b000", 3));
    }
}