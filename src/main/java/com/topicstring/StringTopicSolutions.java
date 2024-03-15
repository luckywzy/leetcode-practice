package com.topicstring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//给定一个字符串数组strsD，在strs中有些位置为null，但在不为null 的位置上，其字符串是按照字典顺序由小到大依次出现的。再给定 一个字符串str，请返回str 在strs中 出现 的最左的位置。
public class StringTopicSolutions {

    public int getIndex(String[] strs, String str) {
        if (strs == null || strs.length == 0) {
            return -1;
        }
        int left = 0;
        int right = strs.length - 1;
        int i = 0;
        int res = -1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (strs[mid] != null && strs[mid].equals(str)) {
                res = mid;
                right = mid - 1;
            } else if (strs[mid] != null) {
                if (strs[mid].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                i = mid;
                while (strs[i] == null && --i >= left) ;
                if (i < left || strs[i].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    res = strs[i].equals(str) ? i : res;
                    right = i - 1;
                }
            }
        }
        return res;
    }

    public void replaceStr(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int num = 0;
        int i = 0;
        for (; i < s.length && s[i] != '0'; i++) {
            if (s[i] == ' ') {
                num++;
            }
        }
        int newLen = i + 2 * num - 1;
        for (int k = i - 1; k >= 0; k--) {
            if (s[k] != ' ') {
                s[newLen--] = s[k];
            } else {
                s[newLen--] = '0';
                s[newLen--] = '2';
                s[newLen--] = '%';
            }
        }
    }

    public void replaceStarToBegin(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        //"12**345"
        int k = s.length - 1;
        for (int j = s.length - 1; j >= 0; j--) {
            if (s[j] != '*') {
                s[k--] = s[j];
            }
        }

        while (k > -1) {
            s[k--] = '*';
        }
    }

    public void reverseWords(char[] s) {
        //"dog loves pig"
        //"gip sevol god"
        //"pig loves dog"
        reverseChars(s, 0, s.length - 1);
        int k = 0;

        int start = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverseChars(s, start, i - 1);
                start = -1;
            } else {
                start = start == -1 ? i : start;
            }
        }
        if (start < s.length - 1) {
            reverseChars(s, start, s.length - 1);
        }
    }

    private static void reverseChars(char[] s, int i, int j) {
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }


    public int MinLengthWithTwoStrings(String[] strs, String a, String b) {
        if (a == null || b == null) return -1;

        int left = -1;
        int right = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(a)) {
                left = i;
            }
            if (strs[i].equals(b)) {
                right = i;
            }
            if (left > 0 && right > 0) {
                res = Math.min(Math.abs(right - left), res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public String MakeStringToHuiWen(String a) {
        //dp[i][j] 在字符串i,j之间最少添加几个字符使得字符串str[i..j]成为回文串
        //dp[i][j]
        //  j-i ==1     dp[i][j] = 0
        //  j-i > 1
        //      str[i] == str[j]    dp[i][j] = d[i+1][j-1]
        //      str[i] != str[j]
        //        min  { dp[i][j] = d[i+1][j] + 1
        //              dp[i][j] = d[i][j-1] + 1 }
        // 初始化：
        //遍历顺序 需要先计算i+1所以要从 i ... 0; 0..j
        //res = dp[0][s.len-1]
        int[][] dp = new int[a.length()][a.length()];
        char[] chars = a.toCharArray();
        for (int j = 1; j < chars.length; j++) {
            dp[j - 1][j] = chars[j - 1] == chars[j] ? 0 : 1;

            for (int i = j - 1; i > -1; i--) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        int i = 0;
        int j = chars.length - 1;
        char[] res = new char[chars.length + dp[0][chars.length - 1]];
        int resLeft = 0;
        int resRight = res.length - 1;

        while (i <= j) {
            if (chars[i] == chars[j]) {
                res[resLeft++] = chars[i++];
                res[resRight--] = chars[j--];
            } else if (dp[i][j - 1] < dp[i + 1][j]) {
                res[resLeft++] = chars[j];
                res[resRight--] = chars[j--];
            } else {
                res[resLeft++] = chars[i];
                res[resRight--] = chars[i++];
            }
        }
        return new String(res);
    }

    public boolean IsValidBrackets(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                l++;
            } else if (chars[i] == ')') {
                r++;
            } else {
                return false;
            }
            if (l < r) {
                return false;
            }
        }
        return l == r;
    }

    public int ValidBracketsMaxLength(String s) {
        int[] dp = new int[s.length()]; //以i结尾的字符串的最长有效括号子串为 dp[i]
        char[] chars = s.toCharArray();
        dp[0] = 0;
        // if str[i] ='(' 非有效 dp[i] = 0
        // id str[i] =')' 有效 有这么几种情况，
        //      "()()" 遍历到")",上一个匹配的"(" 必须出现在pre = i-dp[i-1]-1位置上那么 dp[i] = dp[i-1]+2
        //      "()()())"   dp[i] 除了是 dp[i-1]+2之外，最前面的 "()"也需要计算进去，即加上dp[pre - 1]
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                int pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //字符串表达式求值
    public int ExpressionEvaluation(String s) {
        return 0;
    }

    //给 定 一 个 整 数 N ， 求 由 " o " 字 符 与 " 1 " 字 符 组 成 的 长 度 为 N 的 所 有 字 符 串 中， 满 足 " o " 字 符 的 左 边 必 有 " 1 " 字 符的 字 符 串 数 量 。
    //另一种 斐波那契数列
    public int OneBeforeZero(int n) {
        return 0;
    }

    public String lowerDictSort(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (a + b).compareTo(b + a);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }


    //最长无重复子串
    public int maxLengthNoRepeatStr(String str) {
        char[] chars = str.toCharArray();
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        int result = 0;

        int pre = -1;
        for (int i = 0; i < chars.length; i++) {
            pre = Math.max(pre, lastIndex[chars[i]]); //上一个重复字符的位置
            result = Math.max(result, i - pre);
            lastIndex[chars[i]] = i;
        }
        return result;
    }


    //给定字符串strl 和str2，求strl 的子串中含有str2所有字符的最小子串长度
    public int MinContainsStr(String str1, String str2) {
        //"abcde" "bbc"
        // map 表示 str2 每个字符的数量，b-> 2, c->1，即str1欠str2的字符数量
        //left 表示 左边界， right 表示 右边界，str1[left..right]表示窗口
        //如果滑出了窗口，需要把字符还给map
        //如果全部满足，就计算len
        int[] map = new int[256];
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < str2.length(); i++) {
            map[chars2[i]]++;
        }
        int left = 0;
        int right = 0;
        int match = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < chars1.length) {
            map[chars1[right]]--;
            if (map[chars1[right]] >= 0) {
                match++;
            }
            if (match == str2.length()) {
                //多余的那部分剔除
                while (map[chars1[left]] < 0) {
                    map[chars1[left++]]++;
                }

                minLength = Math.min(minLength, right - left + 1);
                map[chars1[left]]++;
                left++;
                match--;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


    public int CutStringToHuiWen(String s) {
        // "ACDCDCDAD"
        // "A" "CDCDC" "DAD"
        //dp[i] 表示 s[i..len-1]之间至少需要切割几次才能全部切成回文子串
        // dp[i] = if s[i..j]是回文，dp[i] = dp[j+1]+1
        //对 j在i..len-1 枚举 dp[i] = min{dp[i], dp[j+1]+1}
        int[] dp = new int[s.length() + 1];
        boolean[][] p = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();

        dp[chars.length] = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j] && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }

        return dp[0];
    }

}
