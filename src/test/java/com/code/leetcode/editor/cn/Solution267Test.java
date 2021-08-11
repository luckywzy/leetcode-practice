package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/7/29 5:23 下午
 */
public class Solution267Test {

    @Test
    public void generatePalindromes() {

        Solution267 solution267 = new Solution267();
        List<String> abc = solution267.generatePalindromes("abc");
        System.out.println("res:"+ abc.toString());
    }

    @Test
    public void generatePalindromes1() {

        Solution267 solution267 = new Solution267();
        List<String> abc = solution267.generatePalindromes("aabb");
        System.out.println("res:"+ abc.toString());
    }
    @Test
    public void generatePalindromes2() {

        Solution267 solution267 = new Solution267();
        List<String> abc = solution267.generatePalindromes("aabba");
        System.out.println("res:"+ abc.toString());
    }

    @Test
    public void generatePalindromes3() {

        Solution267 solution267 = new Solution267();
        List<String> abc = solution267.generatePalindromes("aabbbba");
        System.out.println("res:"+ abc.toString());
    }

    @Test
    public void generatePalindromes4() {

        Solution267 solution267 = new Solution267();
        List<String> abc = solution267.generatePalindromes("aabbhijkkjih");
        System.out.println("res:"+ abc.toString());
    }


    @Test
    public void generatePalindromes5() {

        Solution267 solution267 = new Solution267();

        System.out.println("res:"+ solution267.generatePalindromes1("aaaaaa").toString());
       /* System.out.println("res:"+ solution267.generatePalindromes1("aaa").toString());
        System.out.println("res:"+ solution267.generatePalindromes1("a").toString());
        System.out.println("res:"+ solution267.generatePalindromes1("abc").toString());
        System.out.println("res:"+ solution267.generatePalindromes1("aabb").toString());
        System.out.println("res:"+ solution267.generatePalindromes1("aabba").toString());
        System.out.println("res:"+ solution267.generatePalindromes1("aabbbba").toString());
        System.out.println("res:"+ solution267.generatePalindromes1("aabbhijkkjih").toString());*/
    }
}