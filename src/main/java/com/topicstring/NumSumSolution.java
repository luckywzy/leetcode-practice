package com.topicstring;

//字符串中数字子串的求和
public class NumSumSolution {

    public int numSum(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int res = 0;
        while (i < chars.length) {
            boolean flag = true;
            while (chars[i] == '-') {
                flag = !flag;
                i++;
            }
            int start = i;
            while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                i++;
            }

            if (start != i) {
                int val = Integer.parseInt(s.substring(start, i));
                val = flag ? val : -val;
                res += val;
            }

            i++;
        }

        return res;
    }
}
