package com.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution244 {
    /**
     * https://leetcode-cn.com/problems/shortest-word-distance-ii/
     * like:243
     *
     * @param wordsDict
     */
    private Map<String, List<Integer>> keyAndIndexMap;

    public Solution244(String[] wordsDict) {
        keyAndIndexMap = new HashMap<>(wordsDict.length);

        for (int i = 0; i < wordsDict.length; i++) {
            if (keyAndIndexMap.containsKey(wordsDict[i])) {
                keyAndIndexMap.get(wordsDict[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                keyAndIndexMap.put(wordsDict[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        for (Integer indexi : keyAndIndexMap.get(word1)) {
            for (Integer indexj : keyAndIndexMap.get(word2)) {
                min = Math.min(min, Math.abs(indexi - indexj));
            }
        }
        return min;
    }
}