package com.code;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/
 */
class TwoSum {

    List<Integer> sorted;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        sorted = new LinkedList<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (sorted.isEmpty()) {
            sorted.add(number);
            return;
        }
        if (sorted.get(sorted.size() - 1) < number) {
            sorted.add(number);
            return;
        }
        if (sorted.get(0) > number) {
            sorted.add(0, number);
            return;
        }
        for (int i = 0; i < sorted.size(); i++) {
            if (sorted.get(i) >= number) {
                sorted.add(i, number);
                return;
            }
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find1(int value) {
        /**
         * 超时
         */
        int l;
        for (l = 0; l < sorted.size() - 1; l++) {
            int i = Collections.binarySearch(sorted, value - sorted.get(l));
            if (i >= 0) {
                //是否有重复
                if (i == l) {
                    return sorted.get(i + 1).equals(sorted.get(i));
                } else {
                    return true;
                }
            }
        }
        return false;
    }


    public static class TwoSum2 {
        /**
         * 使用hash加快速度
         */
        Map<Integer, Integer> keyAndCnt;

        /**
         * Initialize your data structure here.
         */
        public TwoSum2() {
            keyAndCnt = new HashMap<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            if (keyAndCnt.containsKey(number)) {
                keyAndCnt.put(number, keyAndCnt.get(number) + 1);
            } else {
                keyAndCnt.put(number, 1);
            }
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : keyAndCnt.entrySet()) {
                Integer cnt = keyAndCnt.get(value - entry.getKey());
                if (cnt != null) {
                    //重复
                    if (entry.getKey().equals(value - entry.getKey())) {
                        if (cnt > 1) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
            return false;

        }
    }

}