package com.code.leetcode.editor.cn;

//你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下： 
//
// 给你一个字符串 currentState ，其中只含 '+' 和 '-' 。你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效
//的翻转时便意味着游戏结束，则另一方获胜。 
//
// 计算并返回 一次有效操作 后，字符串 currentState 所有的可能状态，返回结果可以按 任意顺序 排列。如果不存在可能的有效操作，请返回一个空列表
// [] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：currentState = "++++"
//输出：["--++","+--+","++--"]
// 
//
// 示例 2： 
//
// 
//输入：currentState = "+"
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= currentState.length <= 500 
// currentState[i] 不是 '+' 就是 '-' 
// 
// Related Topics 字符串 👍 31 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        Set<String> res = new HashSet<>(currentState.length());
        int i = 0;
        int j = 2;
        while (i < j && i <= currentState.length() && j <= currentState.length()) {
            if (currentState.substring(i, j).equals("++")) {
                String found = currentState.substring(0, i) + "--" + currentState.substring(j);
                res.add(found);
            }
            j++;
            i++;
        }
        List<String> strings = new ArrayList<>(res.size());
        strings.addAll(res);
        return strings;
    }


    public List<String> generatePossibleNextMoves_opti1(String currentState) {
        Set<String> res = new HashSet<>(currentState.length());
        int i = 0;
        int j = 2;
        while (i < j && i <= currentState.length() && j <= currentState.length()) {

            if (currentState.charAt(i) == '+' && currentState.charAt(j - 1) == '+') {
                //substring 方法比较慢
                String found = currentState.substring(0, i) + "--" + currentState.substring(j);
                res.add(found);
            }
            j++;
            i++;
        }
        List<String> strings = new ArrayList<>(res.size());
        strings.addAll(res);
        return strings;
    }

    public List<String> generatePossibleNextMoves_opti2(String currentState) {
        List<String> strings = new LinkedList<>();
        int i = 0;
        while (i < currentState.length() - 1) {
            //改用StringBuilder.replace方法
            StringBuilder sb = new StringBuilder(currentState);
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                sb.replace(i, i + 2, "--");
                strings.add(sb.toString());
            }
            i++;
        }
        return strings;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
