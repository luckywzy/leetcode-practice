package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution376Test {

    @Test
    public void wiggleMaxLength() {
        int maxLength = new Solution376().wiggleMaxLength(new int[]{1, 2});
        assertEquals(2, maxLength);
    }

    @Test
    public void wiggleMaxLength1() {
        int maxLength = new Solution376().wiggleMaxLength(new int[]{1,7,4,9,2,5});
        assertEquals(6, maxLength);
    }
    @Test
    public void wiggleMaxLength2() {
        int maxLength = new Solution376().wiggleMaxLength(new int[]{1,2,2,2,3,4});
        assertEquals(2, maxLength);
    }


    @Test
    public void wiggleMaxLength1_1() {
        int maxLength = new Solution376().wiggleMaxLength1(new int[]{1, 2});
        assertEquals(2, maxLength);
    }

    @Test
    public void wiggleMaxLength1_2() {
        int maxLength = new Solution376().wiggleMaxLength1(new int[]{1,7,4,9,2,5});
        assertEquals(6, maxLength);
    }
    @Test
    public void wiggleMaxLength1_3() {
        int maxLength = new Solution376().wiggleMaxLength1(new int[]{1,2,2,2,3,4});
        assertEquals(2, maxLength);
    }
}