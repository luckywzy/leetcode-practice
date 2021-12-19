package com.code.leetcode.editor.cn;

//你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下： 
//
// 给你一个字符串 currentState ，其中只含 '+' 和 '-' 。你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效
//的翻转时便意味着游戏结束，则另一方获胜。默认每个人都会采取最优策略。 
//
// 请你写出一个函数来判定起始玩家 是否存在必胜的方案 ：如果存在，返回 true ；否则，返回 false 。 
// 
//
// 示例 1： 
//
// 
//输入：currentState = "++++"
//输出：true
//解释：起始玩家可将中间的 "++" 翻转变为 "+--+" 从而得胜。 
//
// 示例 2： 
//
// 
//输入：currentState = "+"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= currentState.length <= 60 
// currentState[i] 不是 '+' 就是 '-' 
// 
//
// 
//
// 进阶：请推导你算法的时间复杂度。 
// Related Topics 记忆化搜索 数学 动态规划 回溯 博弈 👍 87 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution294 {
    public boolean canWin(String currentState) {
        Map<String, Boolean> currentWinMap = new HashMap<>();
        return doCanWin(currentState, currentWinMap);

    }

    /**
     * 1、这题不是很懂
     * @param currentState
     * @param currentWinMap
     * @return
     */
    private boolean doCanWin(String currentState, Map<String, Boolean> currentWinMap) {
        if (currentWinMap.containsKey(currentState)) {
            return currentWinMap.get(currentState);
        }
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                StringBuilder sb = new StringBuilder(currentState);
                sb.replace(i, i + 2, "--");
                //当我改变这两个字符后 , 存在一种下一个先手的人必输的情况 ， 那么当前先手的人就是必胜的
                if (!doCanWin(sb.toString(), currentWinMap)) {
                    currentWinMap.put(sb.toString(), false);
                    return true;
                }
                currentWinMap.put(sb.toString(), true);
            }
        }
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
