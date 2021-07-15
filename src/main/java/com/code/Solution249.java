package com.code;


import java.util.*;

class Solution249 {
    /**
     * https://leetcode-cn.com/problems/group-shifted-strings/
     * "abc" -> "bcd" -> ... -> "xyz"
     * ["az","ba"]
     */
    char first = 'a';
    char last = 'z';

    public List<List<String>> groupStrings(String[] strings) {

        HashMap<String, List<Integer>> map = new HashMap<>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            int finalI = i;
            if (map.containsKey(strings[i])) {
                map.computeIfPresent(strings[i], (s, oldVal) -> {
                    oldVal.add(finalI);
                    return oldVal;
                });
            } else {
                ArrayList<Integer> indes = new ArrayList<>();
                indes.add(i);
                map.put(strings[i], indes);
            }

        }

        List<List<String>> ans = new ArrayList<>(strings.length / 2);
        boolean[] seted = new boolean[strings.length];

        for (int i = 0; i < strings.length; i++) {

            List<String> co = new ArrayList<>();
            String next = strings[i];
            do {
                if (map.containsKey(next)) {
                    List<Integer> indexs = map.get(next);
                    for (Integer index : indexs) {
                        if (!seted[index]) {
                            co.add(next);
                            seted[index] = true;
                        }
                    }

                }
                //TODO 这里可以优化，直接获取到下一个字符串
                next = nextStr(next);
            } while (!next.equals(strings[i]));

            if (co.isEmpty()) {
                continue;
            }
            ans.add(co);
        }
        return ans;
    }


    private String nextStr(String s) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = nextChar(s.charAt(i));
        }
        return String.valueOf(chars);
    }

    public char nextChar(char c) {
        int val = c;
        if (last == c) {
            return first;
        }
        return (char) (++val);

    }
}