package com.code;

class Solution246 {
    /**
     * 注；是将数字旋转180度，或者上下颠倒后一样则是中心对称
     * https://leetcode-cn.com/problems/strobogrammatic-number/
     */
    public boolean isStrobogrammatic(String num) {

        int r = num.length() - 1;
        char[] rotate = new char[num.length()];
        for (int i = 0; i < num.length(); i++) {
            int index = look(num.charAt(i));
            if (index >= 0) {
                rotate[r--] = lookup[index][1];
            } else {
                return false;
            }
        }
        return String.valueOf(rotate).equals(num);
    }

    public static char[][] lookup = new char[][]{
            {'6', '9'},
            {'9', '6'},
            {'8', '8'},
            {'1', '1'},
            {'0', '0'}
    };


    private int look(char a) {
        for (int i = 0; i < 5; i++) {
            if (lookup[i][0] == a) {
                return i;
            }
        }
        return -1;
    }
}