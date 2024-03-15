package com.topicstring;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringTopicSolutionsTest {

    @Test
    public void getIndex() {
        assertEquals(1, new StringTopicSolutions().getIndex(new String[]{null, "a", null, "a", null, "b", null, "c"}, "a"));
    }

    @Test
    public void replaceStr() {
        char[] chars = new char[12];
        chars[0] = 'a';
        chars[1] = ' ';
        chars[2] = 'b';
        chars[3] = ' ';
        chars[4] = ' ';
        chars[5] = 'c';
        chars[6] = '0';
        new StringTopicSolutions().replaceStr(chars);
        assertEquals("a%20b%20%20c", new String(chars));
    }

    @Test
    public void replaceStarToBegin() {
        char[] chars = "12**345".toCharArray();
        new StringTopicSolutions().replaceStarToBegin(chars);
        assertEquals("**12345", new String(chars));
    }

    @Test
    public void reverseWords() {
        char[] chars = "dog loves pig".toCharArray();
        new StringTopicSolutions().reverseWords(chars);
        assertEquals("pig loves dog", new String(chars));
    }

    @Test
    public void reverseWords1() {
        char[] chars = "I'm a student.".toCharArray();
        new StringTopicSolutions().reverseWords(chars);
        assertEquals("student. a I'm", new String(chars));
    }

    @Test
    public void minLengthWithTwoStrings() {
        assertEquals(2, new StringTopicSolutions().MinLengthWithTwoStrings(
                new String[]{"1", "3", "3", "3", "2", "3", "1"},
                "1",
                "2"
        ));
        assertEquals(-1, new StringTopicSolutions().MinLengthWithTwoStrings(
                new String[]{"CD"},
                "CD",
                "AB"
        ));
    }

    @Test
    public void makeStringToHuiWen() {
        String res = new StringTopicSolutions().MakeStringToHuiWen("A1B21C");
        assertEquals("AC1B2B1CA", res);
    }

    @Test
    public void isValidBrackets() {
        assertEquals(true, new StringTopicSolutions().IsValidBrackets("(())"));
        assertEquals(false, new StringTopicSolutions().IsValidBrackets("(()))"));
        assertEquals(false, new StringTopicSolutions().IsValidBrackets("(())())"));
        assertEquals(false, new StringTopicSolutions().IsValidBrackets("()("));
        assertEquals(false, new StringTopicSolutions().IsValidBrackets("()a()"));
        assertEquals(true, new StringTopicSolutions().IsValidBrackets("(()())"));
    }

    @Test
    public void validBracketsMaxLength() {
        assertEquals(6,new StringTopicSolutions().ValidBracketsMaxLength("((()))"));
        assertEquals(6,new StringTopicSolutions().ValidBracketsMaxLength("((())))"));
        assertEquals(8,new StringTopicSolutions().ValidBracketsMaxLength("()((())))"));
        assertEquals(4,new StringTopicSolutions().ValidBracketsMaxLength("()())"));
    }

    @Test
    public void lowerDictSort() {
        assertEquals("bab", new StringTopicSolutions().lowerDictSort(new String[]{"b","ba"}));
        assertEquals("abcde", new StringTopicSolutions().lowerDictSort(new String[]{"abc","de"}));
    }

    @Test
    public void maxLengthNoRepeatStr() {
        assertEquals(3,new StringTopicSolutions().maxLengthNoRepeatStr("abca"));
        assertEquals(3,new StringTopicSolutions().maxLengthNoRepeatStr("aabcb"));
    }

    @Test
    public void minContainsStr() {
        assertEquals(3, new StringTopicSolutions().MinContainsStr("abcde", "ac"));
        assertEquals(0, new StringTopicSolutions().MinContainsStr("12345", "344"));
        assertEquals(3, new StringTopicSolutions().MinContainsStr("adabbca", "acb"));
    }

    @Test
    public void cutStringToHuiWen() {
        assertEquals(3, new StringTopicSolutions().CutStringToHuiWen("ACDCDCDAD"));
    }
}